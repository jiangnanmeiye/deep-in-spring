package com.tomingdom.spring.propertySource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertyConfigExample1 {
    public static void main(String[] args) throws IOException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:app-config.xml");
        Properties properties = PropertiesLoaderUtils.loadProperties(ctx.getResource("classpath:app-env.properties"));
        System.out.println(properties.getProperty("message"));
        ctx.close();
    }


}
