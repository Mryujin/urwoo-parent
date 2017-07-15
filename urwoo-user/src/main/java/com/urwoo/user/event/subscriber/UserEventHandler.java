package com.urwoo.user.event.subscriber;

import com.google.common.eventbus.Subscribe;
import com.urwoo.basic.tool.ObjectTools;
import com.urwoo.user.domain.event.UserCreatedEvent;
import com.urwoo.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    private Logger logger = LoggerFactory.getLogger(UserEventHandler.class);

    @Autowired
    private UserRepository userRepository;

    @Subscribe
    public void created(UserCreatedEvent event) {
        logger.info("created() : event={}", ObjectTools.toString(event.getUserModelDTO()));
        try {
            userRepository.save(event.getUserModelDTO());
        } catch (Exception e) {
            logger.error("段子种类数据从数据库失败保存失败", e);
            e.printStackTrace();
        }
    }

}
