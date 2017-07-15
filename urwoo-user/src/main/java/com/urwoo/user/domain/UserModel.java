package com.urwoo.user.domain;

import com.google.common.eventbus.EventBus;
import com.urwoo.basic.base.BaseModel;
import com.urwoo.basic.constant.*;
import com.urwoo.user.domain.command.UserCreatedCommand;
import com.urwoo.user.domain.event.UserCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends BaseModel {

    private String username;
    private String phone;
    private String email;
    private String loginType;
    private String password;
    private String nickname;
    private String avatar;
    private Gender gender;
    private Status status;
    private String meta;
    private String md5;
    private Level level;
    private Role role;

    private EventBus eventBus;

    public UserModel(EventBus eventBus){
        this.eventBus = eventBus;
    }

    public void register(UserCreatedCommand userCreatedCommand){
        this.username = userCreatedCommand.getUserModelVO().getUsername();
        this.phone = userCreatedCommand.getUserModelVO().getPhone();
        this.email = userCreatedCommand.getUserModelVO().getEmail();
        this.loginType = userCreatedCommand.getUserModelVO().getLoginType();
        this.nickname = userCreatedCommand.getUserModelVO().getNickname();
        this.avatar = userCreatedCommand.getUserModelVO().getAvatar();
        this.gender = userCreatedCommand.getUserModelVO().getGender();
        this.status = userCreatedCommand.getUserModelVO().getStatus();
        this.meta = userCreatedCommand.getUserModelVO().getMeta();
        this.md5 = userCreatedCommand.getUserModelVO().getMd5();
        this.level = userCreatedCommand.getUserModelVO().getLevel();

        this.eventBus.post(new UserCreatedEvent(userCreatedCommand.getUserModelVO()));
    }
}
