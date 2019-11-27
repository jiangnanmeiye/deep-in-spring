package com.tomingdom.spring.aop.introduction;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionDemo {
    public static void main(String[] args) {
        Contact target = new Contact();
        target.setName("John Mayer");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);
        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("IsModified?: " + (proxy instanceof IsModified));

        System.out.println("Has been modified?: " + proxyInterface.isModified());
        proxy.setName("Kobe Bryant");
        System.out.println("Has been modified?: " + proxyInterface.isModified());
    }
}
