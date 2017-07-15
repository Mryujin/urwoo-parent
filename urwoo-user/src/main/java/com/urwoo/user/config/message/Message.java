package com.urwoo.user.config.message;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "message")
@PropertySource(value = "classpath:message.properties", encoding = "UTF-8")
public class Message {

    private String userNotExist;
    private String userUsernameExist;
    private String userAccountPaused;
    private String userPasswordError;
}
