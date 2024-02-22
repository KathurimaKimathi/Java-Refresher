package org.hummingbird;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "org.hummingbird")
public class BeanConfig {

    // You can also configure your beans here and remove the Component annotation from Doctor.java
    @Bean
    public Doctor doctor() {
        return new Doctor();
    }
}
