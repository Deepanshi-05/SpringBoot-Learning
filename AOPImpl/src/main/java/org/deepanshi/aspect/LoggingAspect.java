package org.deepanshi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    @Before("execution(org.deepanshi.service.StudentService.createStudent")
    public void logBeforeMethod(JoinPoint joinPoint) {

        Object[] arr =  joinPoint.getArgs();
        System.out.println("Student is going to be saved");

        boolean allowed = true;

        if(!allowed){
           throw new RuntimeException("Method not allowed");
        }
    }

    @AfterReturning("execution(org.deepanshi.service.StudentService.createStudent")
    public void logAfterReturningMethod(JoinPoint joinPoint) {
        System.out.println("logAfterReturningMethod called");
    }
    //After Returning mein kuchh bhi return kar do wo return nahi hota
    //Return wahi hota hai jo Student Service return kar raha hota hai
}
