package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LogAdvice {
    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("==============================");
    }

    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1:" + str1);
        log.info("str2:" + str2);
    }

    @AfterThrowing(pointcut = "execution(* org.scoula.sample.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception...!!!!");
        log.info("exception: " + exception);
    }

    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) { // pjp는 현재 호출된, AOP가 적용된 메서드를 가리킨다.
        long start = System.currentTimeMillis(); // 시작 시간 측정

        log.info("Target: " + pjp.getTarget()); // 객체 확인
        log.info("Param: " + Arrays.toString(pjp.getArgs())); // 매개변수 확인

        Object result = null;
        try {
            result = pjp.proceed(); // 실제 메서드 호출
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis(); // 종료 시간 측정

        log.info("TIME: " + (end - start)); // 실행 소요 시간 출력

        return result;
    }
}
