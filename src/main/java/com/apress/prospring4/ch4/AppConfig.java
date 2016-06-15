package com.apress.prospring4.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.apress.prospring3.ch2.MessageProvider;
import com.apress.prospring3.ch2.MessageRenderer;

@Configuration
@ImportResource(value = "classpath:META-INF/spring/app-context-AppConfig.xml")
@PropertySource(value = "classpath:message.properties")
@ComponentScan(basePackages = { "com.apress.prospring4.ch4" })
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }

}
