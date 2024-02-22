package org.hummingbird;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(org.hummingbird..*)")
    public void authenticationCutPoint() {
        System.out.println("Authentication cut point");
    }

    @Pointcut("within(org.hummingbird..*)")
    public void authorizationCutPoint() {
        System.out.println("Authorization cut point");
    }

    @Before("authenticationCutPoint() && authorizationCutPoint()")
    public void authenticate() {
        System.out.println("Authenticating...");
    }
}
