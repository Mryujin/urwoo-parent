package com.urwoo.user.domain.event;

import com.urwoo.user.domain.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreatedEvent {

    private final UserModel userModelDTO;
}
