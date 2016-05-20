package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithInterface implements InitializingBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
	this.name = name;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public void myInit() {
	System.out.println("My init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
	System.out.println("Initializing bean");

	if (name == null) {
	    System.out.println("Using default name");
	    name = DEFAULT_NAME;
	}

	if (age == Integer.MIN_VALUE) {
	    throw new IllegalArgumentException(
		    "You must set the age property of any beans of type " + SimpleBeanWithInterface.class);
	}
    }

    @Override
    public String toString() {
	return "SimpleBeanWithInterface [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-InitializingBeanInterface.xml");
	ctx.refresh();

	SimpleBeanWithInterface sb1 = getBean("simpleBean1", ctx);
	SimpleBeanWithInterface sb2 = getBean("simpleBean2", ctx);
	SimpleBeanWithInterface sb3 = getBean("simpleBean3", ctx);
    }

    private static SimpleBeanWithInterface getBean(String beanName, GenericXmlApplicationContext ctx) {
	try {
	    SimpleBeanWithInterface bean = (SimpleBeanWithInterface) ctx.getBean(beanName);
	    System.out.println(bean);
	    return bean;
	} catch (BeanCreationException bce) {
	    System.out.println("An error occured in bean configuration: " + bce.getMessage());
	    return null;
	}
    }

}
