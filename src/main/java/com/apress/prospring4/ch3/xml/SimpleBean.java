package com.apress.prospring4.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private int age;
    private String name;

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-beanInheritance.xml");
	ctx.refresh();

	SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
	SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");

	System.out.println("Parent:\n" + parent);
	System.out.println("Child:\n" + child);
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
