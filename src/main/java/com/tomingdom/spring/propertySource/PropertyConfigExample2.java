package com.tomingdom.spring.propertySource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app-env.properties")
public class PropertyConfigExample2 {

    private String message;

    @Autowired
    public void setMessage(@Value("${message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfigExample2.class);
        PropertyConfigExample2 propertyConfigExample2 = ctx.getBean(PropertyConfigExample2.class);
        System.out.println(propertyConfigExample2.getMessage());
    }

}
