package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamePrinterExample {

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-xml-BeanNameAware.xml");
	ctx.refresh();

	BeanAwareNamePrinter bean = (BeanAwareNamePrinter) ctx.getBean("beanNamePrinter");
	bean.someOperation();

    }

}
