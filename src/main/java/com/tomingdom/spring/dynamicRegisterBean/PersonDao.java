package com.tomingdom.spring.dynamicRegisterBean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PersonDao {
    private final String sentence = "Hello World";
}
