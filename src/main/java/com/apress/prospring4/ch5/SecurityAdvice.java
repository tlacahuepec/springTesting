package com.apress.prospring4.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object tarjet) throws Throwable {
        UserInfo user = securityManager.getLoggedUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if ("jaime".equals(user.getUserName())) {
            System.out.println("Logged in user is Jaime !");
        } else {
            System.out.println("Logged in user is " + user.getUserName() + " that is not good");
            throw new SecurityException(
                    "User: " + user.getUserName() + " is not allowed access to method: " + method.getName());
        }
    }

}
