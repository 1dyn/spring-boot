package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    // 해당 타입에 대해 리턴을 optional하게 해주 메소드
    Optional<T> findById(int index);

    // 저장
    T save(T entity);

    // 삭제
    void deleteById(int index);

    // 가지고 있는 모든 리스트 반환
    List<T> findAll();

}
