package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public void init() {
	System.out.println("Initializing bean");

	if (name == null) {
	    System.out.println("Using default name");
	    name = DEFAULT_NAME;
	}
	if (age == Integer.MIN_VALUE) {
	    throw new IllegalArgumentException(
		    "You must set the age property of any beans of type " + SimpleBean.class);
	}

    }

    @Override
    public String toString() {
	return "SimpleBean [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-Initialization.xml");
	ctx.refresh();

	SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
	SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
	SimpleBean simpleBean3 = getBean("simpleBean3", ctx);

    }

    private static SimpleBean getBean(String beanName, GenericXmlApplicationContext ctx) {
	try {
	    SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
	    System.out.println(bean);
	    return bean;
	} catch (BeanCreationException bce) {
	    System.out.println("An error occured in bean configuration: " + bce.getMessage());
	    return null;
	}
    }

}
