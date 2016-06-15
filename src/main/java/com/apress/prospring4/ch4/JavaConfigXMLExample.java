package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring3.ch2.MessageRenderer;

public class JavaConfigXMLExample {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/app-context-Message.xml");

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();

    }

}
