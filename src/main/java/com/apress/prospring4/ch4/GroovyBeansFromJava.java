package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:beans.groovy");
        // ApplicationContext ctx = new
        // GenericGroovyApplicationContext("classpath:GroovyConfig.groovy");

        Contact contact = ctx.getBean("contact", Contact.class);
        System.out.println(contact);
    }

}
