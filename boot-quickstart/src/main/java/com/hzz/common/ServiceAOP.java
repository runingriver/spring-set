package com.hzz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAOP {
    private static final Logger logger = LoggerFactory.getLogger(ServiceAOP.class);

    @Before("execution(* com.hzz.service..*Service.*(..))")
    public void beforeServiceAccess(JoinPoint joinPoint) {
        logger.info("before enter:" + joinPoint.toShortString());
    }

    @After("execution(* com.hzz.service..*Service.*(..))")
    public void afterServiceAccess(JoinPoint joinPoint) {
        logger.info("Completed: {}", joinPoint);
    }

}
