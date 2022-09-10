package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// @RestControllerAdvice(basePackages = com.example.exception.advice.GlobalControllerAdvice)
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class) // 어떤 error를 잡을지 value값을 통해 명시
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getClass());
        System.out.println("--------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("--------------------");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
