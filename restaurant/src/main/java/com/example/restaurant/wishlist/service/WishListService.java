package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

    public WishListDto search(String query) {

        // 지역 검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if (searchLocalRes.getTotal() > 0) { // 지역검색 결과가 있을 때
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", ""); // 잡다한 문자열 제거

            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            // 이미지 검색
            var searchImageRes = naverClient.searchImage(searchImageReq);

            if (searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 결과 리턴
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;
            }
        }
        return new WishListDto();
    }

    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        WishListEntity saveEntity = (WishListEntity) wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto) {
        var entity = new WishListEntity();
        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());

        return entity;
    }

    private WishListDto entityToDto(WishListEntity WishListEntity) {
        var dto = new WishListDto();
        dto.setIndex(WishListEntity.getIndex());
        dto.setTitle(WishListEntity.getTitle());
        dto.setCategory(WishListEntity.getCategory());
        dto.setAddress(WishListEntity.getAddress());
        dto.setRoadAddress(WishListEntity.getRoadAddress());
        dto.setHomePageLink(WishListEntity.getHomePageLink());
        dto.setImageLink(WishListEntity.getImageLink());
        dto.setVisit(WishListEntity.isVisit());
        dto.setVisitCount(WishListEntity.getVisitCount());
        dto.setLastVisitDate(WishListEntity.getLastVisitDate());

        return dto;
    }

    public List<WishListDto> findAll() {
        return (List<WishListDto>) wishListRepository.findAll()
                .stream()
                .map(it -> entityToDto((WishListEntity) it)).collect(Collectors.toList());
    }

    public void delete(int index) {
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index) {
        var wishItem = wishListRepository.findById(index);
        if ( wishItem.isPresent()) { // 있으면
            WishListEntity item = (WishListEntity) wishItem.get();

            item.setVisit(true);
            item.setVisitCount(item.getVisitCount() + 1);
        }
    }
}
