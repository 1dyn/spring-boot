package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    // com.example의 aop프로젝트의 controller패키지 하위에 있는 모든 메소드를 aop로 보겠다
    private void cut() {}


    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer() {}

    @Around("cut() && enableTimer()") // 두가지 조건을 같이 사용한다
    // 시간을 잴건데 before와 after가 있으면 time을 공유할 수 없기 때문에 around사용
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed(); // 여길 기준으로 위는 before, 아래는 after이다

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
