package com.urwoo.user.domain.command;

import com.urwoo.user.domain.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreatedCommand {

    private final UserModel userModelVO;
}
