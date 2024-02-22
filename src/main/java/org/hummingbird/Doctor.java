package org.hummingbird;

import org.springframework.stereotype.Component;

//@Component - commented out to show that the bean can be configured in BeanConfig.java
public class Doctor implements Staff {
    public void assist() {
        System.out.println("The doctor is assisting.");
    }
}
