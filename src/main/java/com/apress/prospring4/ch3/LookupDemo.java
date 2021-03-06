package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-xml.xml");
	ctx.refresh();

	DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
	DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");

	displayInfo(standardBean);
	displayInfo(abstractBean);
    }

    private static void displayInfo(DemoBean bean) {
	MyHelper h1 = bean.getMyHelper();
	MyHelper h2 = bean.getMyHelper();

	System.out.println("Helper Instances the Same?: " + (h1 == h2));

	StopWatch stopWatch = new StopWatch();

	stopWatch.start("lookupDemo");

	for (int x = 0; x < 100000; x++) {
	    MyHelper helper = bean.getMyHelper();
	    helper.doSomethingHelpful();
	}

	stopWatch.stop();

	System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
