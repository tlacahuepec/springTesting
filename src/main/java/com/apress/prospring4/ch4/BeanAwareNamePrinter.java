package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanNameAware;

public class BeanAwareNamePrinter implements BeanNameAware {

    private String beanName;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.
     * String)
     */
    @Override
    public void setBeanName(String beanName) {
	this.beanName = beanName;
    }

    public void someOperation() {
	System.out.println("Bean [" + beanName + "] - someOperation()");
    }

}
