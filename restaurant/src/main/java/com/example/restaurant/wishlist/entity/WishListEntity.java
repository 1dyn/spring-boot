package com.example.restaurant.wishlist.entity;

import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListEntity extends MemoryDbEntity {

    // MemoryDbEntity 클래스 안에 있는 것
    // protected int index;

    private String title; // 음식명, 장소명
    private String category; // 카테고리
    private String address; // 주소
    private String roadAddress; // 도로명
    private String homePageLink; // 홈페이지 주소
    private String imageLink; // 음식, 가게 이미지 주소
    private boolean isVisit; // 방문 여부
    private int visitCount; // 방문 카운트
    private LocalDateTime lastVisitDate; // 마지막 방문일지

}
