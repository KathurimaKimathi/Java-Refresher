package org.hummingbird;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    // Implement aspects for:
    // 1. Logging
    // 2. Security (Authentication and Authorization)
    // 3. Sanitizing data
    public void checkout(String status) {
        System.out.println("Checking out...");
    }
}
