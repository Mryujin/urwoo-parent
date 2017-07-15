package com.urwoo.article.config.eventbus;

import com.google.common.eventbus.EventBus;
import com.urwoo.article.event.subscriber.ArticleCategoryEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfig {

    @Autowired
    private ArticleCategoryEventHandler articleCategoryEventHandler;

    @Bean(name = "eventBus")
    public EventBus eventBus(){
        EventBus eventBus = new EventBus();
        eventBus.register(articleCategoryEventHandler);
        return eventBus;
    }
}
