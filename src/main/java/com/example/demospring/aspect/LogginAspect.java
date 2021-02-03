package com.example.demospring.aspect;

import com.example.demospring.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    Logger Log = LoggerFactory.getLogger(LogginAspect.class);

    @Pointcut("execution(* com.example.demospring.service.Impl.ProductServiceImpl.createProduct(..))")
    public void controllerPointcut(){

    }

    @Around("controllerPointcut()")
    public Object applicationLogger(ProceedingJoinPoint jp) throws Throwable {

        ObjectMapper mapper = new ObjectMapper();
        String methodName = jp.getSignature().getName();
        String className = jp.getTarget().getClass().toString();
        String objects  = jp.getArgs()[0].toString();
        Log.info("Method Invoked:{} ->{} with arguments: {}", className, methodName, objects);

        Object response = jp.proceed();
        Log.info("Method Invoked:{} ->{} with arguments: {}", className, methodName, mapper.writeValueAsString(response));
        return response;


    }

    @Around("@annotation(com.example.demospring.annotations.Time)")
    public void timetracker(ProceedingJoinPoint jp) throws Throwable{
        Long startTime  =System.currentTimeMillis();
        jp.proceed();
        Long endTime =System.currentTimeMillis();
        Log.info("Time taken :{}",endTime-startTime);

    }
}
