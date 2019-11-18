package com.tomingdom.spring.propertySource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app-env.properties")
public class PropertyConfigExample3 {
    private Environment env;

    public Environment getEnv() {
        return env;
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfigExample3.class);
        PropertyConfigExample3 propertyConfigExample3 = ctx.getBean(PropertyConfigExample3.class);
        Environment env = propertyConfigExample3.getEnv();
        System.out.println(env.getProperty("message"));
    }
}
