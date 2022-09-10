package com.example.restaurant.db;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Data에 해당하는 공통적인 사항들을 정의해놓은 클래스
public class MemoryDbEntity {

    protected Integer index;


}
