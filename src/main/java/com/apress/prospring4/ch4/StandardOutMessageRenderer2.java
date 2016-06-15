package com.apress.prospring4.ch4;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.apress.prospring3.ch2.MessageProvider;
import com.apress.prospring3.ch2.MessageRenderer;

@Named("messageRenderer2")
@Singleton
public class StandardOutMessageRenderer2 implements MessageRenderer {

    @Inject
    @Named("messageProvider")
    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class: "
                    + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }

}
