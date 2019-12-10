package com.tomingdom.spring.dynamicRegisterBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class App {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        //测试BeanDefinitionRegistry
        PersonManager personManager = (PersonManager) ctx.getBean("personManager1");
        PersonDao personDao = personManager.getPersonDao();
        System.out.println(personDao.getSentence());

        //测试SingletonBeanDefinitionRegistry
        PersonManager personManager1 = (PersonManager) ctx.getBean("personManager2");
        PersonDao personDao1 = personManager1.getPersonDao();
        System.out.println(personDao1.getSentence());
    }
}
