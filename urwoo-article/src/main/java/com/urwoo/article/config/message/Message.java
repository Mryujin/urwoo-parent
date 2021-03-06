package com.urwoo.article.config.message;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "message")
@PropertySource(value = "classpath:message.properties", encoding = "UTF-8")
public class Message {

    private String articleCateNotExist;
    private String articleCateNameExist;
}
