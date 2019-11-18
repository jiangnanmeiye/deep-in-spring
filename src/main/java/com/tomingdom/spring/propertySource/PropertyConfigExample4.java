package com.tomingdom.spring.propertySource;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertyConfigExample4 {
    public static void main(String[] args) throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties("app-env.properties");
        System.out.println(properties.getProperty("message"));
    }
}
