package org.hummingbird;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Staff staffDoctor = context.getBean(Doctor.class);
        staffDoctor.assist();

    }
}