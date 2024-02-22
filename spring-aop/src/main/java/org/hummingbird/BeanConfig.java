package org.hummingbird;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.hummingbird")
@EnableAspectJAutoProxy
public class BeanConfig {
}
