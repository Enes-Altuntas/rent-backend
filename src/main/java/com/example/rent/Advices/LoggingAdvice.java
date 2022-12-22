package com.example.rent.Advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Before("execution(* com.example.rent.*.*.*.*(..))")
    public void beforeLog(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("İşi Başlayan Sınıf: " + className + " , " + "İşi Başlayan Metod: " + methodName);
    }

    @After("execution(* com.example.rent.*.*.*.*(..))")
    public void afterLog(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("İşi Biten Sınıf: " + className + " , İşi Biten Metod: " + methodName);
    }

    @AfterThrowing(pointcut = "execution(* com.example.rent.*.*.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("Hata Atan Sınıf: {}.{}() Hata Mesajı: {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : e.getMessage());
    }
}
