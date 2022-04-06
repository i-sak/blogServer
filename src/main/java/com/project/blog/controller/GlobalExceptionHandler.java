package com.project.blog.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // 전역 예외 처리기로 사용한다.
@RestController
public class GlobalExceptionHandler {

    // 수학과 관련된 예외 (Exception)
    @ExceptionHandler(value = ArithmeticException.class)
    public Map<String, String> handleArithMaticException(ArithmeticException e) {
        Map<String, String> res = new HashMap<>();
        res.put("errorMsg", e.getMessage());
        res.put("status", "error");
        return res;
    }

    // 예외 종류를 세팅한다.
    @ExceptionHandler(value = Exception.class) // 모든 예외
    // json 반환으로 처리하기 위해 return type은 Map
    // 예외를 파라미터로 받기 때문에 해당 타입을 인자로 넣는다.
    public Map<String, String> handleException(Exception e) {
        // Controller 만들 듯이 return 해주면 된다.
        Map<String, String> res = new HashMap<>();
        res.put("errorMsg", e.getMessage());
        res.put("status", "error");
        return res;
    }
}
