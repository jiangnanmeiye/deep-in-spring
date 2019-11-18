package com.tomingdom.spring.propertySource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertyConfigExample {
    public static void main(String[] args) throws IOException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:app-config.xml");
        Resource resource = ctx.getResource("classpath:app-env.properties");
        Properties property = new Properties();
        property.load(resource.getInputStream());
        System.out.println(property.getProperty("message"));
        ctx.close();
    }
}
