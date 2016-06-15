package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecureBean();

        mgr.login("jaime", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("user", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException se) {
            System.out.println("Exception caught: " + se.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException se) {
            System.out.println("Exception Caught: " + se.getMessage());

        }

    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        return (SecureBean) factory.getProxy();
    }
}
