package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    // com.example의 aop프로젝트의 controller패키지 하위에 있는 모든 메소드를 aop로 보겠다
    private void cut() {}


    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecoder() {}

    @Before("cut() && enableDecoder()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if (arg instanceof User) { // argument를 돌다가 내가 원하는 User 클래스가 매칭이 되면
                User user = User.class.cast(arg); // User 클래스로 형변환시킴
                String base64Email = user.getEmail(); // 그후 기존에 있던 base64 email을 꺼내서
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8"); // decoding을 시켜서
                user.setEmail(email); // 다시 set을 해줌
                // 이렇게 되면 controller 코드에서 user라는 객체를 디코드할 일이 없다
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecoder()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if (returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = new String(Base64.getEncoder().encodeToString(email.getBytes()));
            user.setEmail(base64Email);
        }
    }
}
