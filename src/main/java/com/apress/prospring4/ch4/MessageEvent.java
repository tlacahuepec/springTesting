package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

    private static final long serialVersionUID = -5738202791836572456L;

    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

}
