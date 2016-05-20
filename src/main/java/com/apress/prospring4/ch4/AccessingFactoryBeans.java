package com.apress.prospring4.ch4;

import java.security.MessageDigest;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AccessingFactoryBeans {

    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-FactoryBeans.xml");
	ctx.refresh();

	MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");

	try {
	    MessageDigest shaDigest = factoryBean.getObject();
	    System.out.println(shaDigest.digest("ola ke ase".getBytes()));
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
