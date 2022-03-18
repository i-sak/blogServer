package com.project.blog.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect     // 컴포넌트와 함께 해서 Aspect로 setting
@Component  // server 로드 시 컴포넌트가 같이 세팅되어 적용된다.
public class LoggingAspect {

    // point-cut 문법 : spring-aop 에선 메소드 단위의 위치를 지정한다.
    @Around("execution(* com.project.blog.controller.UserStudyController.*(..))")
    // advice 그리고, point-cur + advice 를 aspect라고 한다.
    public Object setLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("실행 시작 : "
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());
        long startMillis = System.currentTimeMillis();
        Object result = pjp.proceed();
        long executionMillis = System.currentTimeMillis() - startMillis;
        System.out.println("실행 완료 : " + executionMillis + "밀리초 소요됨"
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());
        return result;  // return하면 Around Aspect가 실행된다.
    }

    // Aspect
    @Before("execution(* com.project.blog.service.*.get*(..))") // point-cut
    // methods 단위에서만 위치 지정이 가능하고,
    // naming 컨벤션으로 get으로 시작하는 모든 메소드를 지정
    public void logger() { // advice
        System.out.println("logger test before service methods");
    }
}
