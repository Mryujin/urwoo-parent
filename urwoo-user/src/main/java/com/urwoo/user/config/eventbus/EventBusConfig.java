package com.urwoo.user.config.eventbus;

import com.google.common.eventbus.EventBus;
import com.urwoo.user.event.subscriber.UserEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfig {

    @Autowired
    private UserEventHandler userEventHandler;

    @Bean(name = "eventBus")
    public EventBus eventBus(){
        EventBus eventBus = new EventBus();
        eventBus.register(userEventHandler);
        return eventBus;
    }
}
