package com.apress.prospring4.ch4;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        try {
            File file = File.createTempFile("test", ".txt");
            file.deleteOnExit();

            System.out.println(file.getPath());
            Resource res1 = ctx.getResource("file://" + file.getPath());
            displayInfo(res1);

            Resource res2 = ctx.getResource("classpath:" + file.getName());
            displayInfo(res2);

            Resource res3 = ctx.getResource("http://www.google.com");
            displayInfo(res3);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void displayInfo(Resource res) throws IOException {
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }

}
