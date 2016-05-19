package com.apress.prospring4.ch3;

public class StandardLookupDemoBean implements DemoBean {

    private MyHelper myHelper;

    public MyHelper getMyHelper() {
	return this.myHelper;
    }

    public void someOperation() {
	this.myHelper.doSomethingHelpful();
    }

    public void setMyHelper(MyHelper myHelper) {
	this.myHelper = myHelper;
    }

}
