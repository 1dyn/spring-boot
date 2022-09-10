package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    // com.example의 aop프로젝트의 controller패키지 하위에 있는 모든 메소드를 aop로 보겠다
    private void cut() {}

    // @Before("cut()") // cut()이 실행되기 이전에 실행하겠다
    public void before(JoinPoint joinPoint) { // 들어가는 지점에 대한 정보들을 가지고있는 객체

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs(); // method에 들어가고있는 parameter의 배열

        for(Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    // @AfterReturning(value = "cut()", returning = "returnObj") // 받고 싶은 object의 이름을 넣어준다
    public void afterReturn(JoinPoint joinPoint, Object returnObj) { // afterReturning같은 경우는 object를 받을 수 있다
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
