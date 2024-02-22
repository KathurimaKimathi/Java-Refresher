package org.hummingbird;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Doctor staffDoctor = context.getBean(Doctor.class);
        staffDoctor.assist();
        System.out.println(staffDoctor.getQualification());

        Staff staffNurse = context.getBean(Nurse.class);
        staffNurse.assist();
    }
}