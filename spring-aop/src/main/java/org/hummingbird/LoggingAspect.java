package org.hummingbird;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.hummingbird.ShoppingCart.checkout(..))")
    public void beforeLogger() {
        System.out.println("Before Loggers here");
    }

    @After("execution(* *.*.ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("After Loggers here");
    }
}
