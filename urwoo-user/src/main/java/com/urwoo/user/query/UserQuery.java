package com.urwoo.user.query;

import com.urwoo.basic.constant.Status;
import com.urwoo.basic.tool.ObjectTools;
import com.urwoo.user.domain.UserModel;
import com.urwoo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQuery {

    @Autowired
    private UserRepository userRepository;

    public UserModel get(String username) {
        UserModel user = userRepository.get(username);
        if (ObjectTools.nonNull(user) &&
                ObjectTools.nonEquals(user.getStatus(), Status.ON)){
            return null;
        }
        return user;
    }
}
