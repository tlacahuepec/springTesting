package com.apress.prospring4.ch3;

public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract MyHelper getMyHelper();

    public void someOperation() {
	getMyHelper().doSomethingHelpful();
    }

}
