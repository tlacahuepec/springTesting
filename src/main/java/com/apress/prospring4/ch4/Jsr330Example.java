package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch2.MessageRenderer;

public class Jsr330Example {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-JSR-330.xml");
        ctx.refresh();

        MessageRenderer renderer = ctx.getBean("messageRenderer2", MessageRenderer.class);

        renderer.render();
    }

}
