package codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Log {
    int count = 0;
    @Pointcut("execution(* codegym.controller.BooksController.*(..))")
    public void allMethodPointCut(){}

    @AfterReturning("allMethodPointCut()")
    public void aroundCallMethod( JoinPoint joinPoint) {
        count++;
        System.out.println("METHOD NAME :" +
                joinPoint.getSignature().getName() +
                "Time " + LocalDateTime.now() +
                " Count Number View Page :" + count);
    }

    @Pointcut("execution(* codegym.controller.BooksController.check*(..))")
    public void methodCheck() {
    }

    @Before("methodCheck()")
    public void borrowBook( JoinPoint joinPoint) {
        System.err.println("method:" + joinPoint.getSignature().getName() +
                " class name:" + joinPoint.getSignature().getDeclaringTypeName());
    }

    @AfterReturning("methodCheck()")
    public void payBook(JoinPoint joinPoint) {
        System.err.println("method:" + joinPoint.getSignature().getName() +
                " class name:" + joinPoint.getSignature().getDeclaringTypeName());
    }
}
