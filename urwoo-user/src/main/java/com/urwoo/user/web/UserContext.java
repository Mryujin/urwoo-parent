package com.urwoo.user.web;

import com.urwoo.basic.tool.StringTools;
import com.urwoo.user.config.message.Message;
import com.urwoo.user.domain.UserModel;
import com.urwoo.user.query.UserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserContext {

    private Logger logger = LoggerFactory.getLogger(UserContext.class);

    @Autowired
    private UserQuery userQuery;
    @Autowired
    private Message message;

    @GetMapping(path = "/user/get/{openId}")
    public ResponseEntity get(@PathVariable(name = "openId") String openId) throws Exception {

        logger.info("get() : username={}", openId);

        return Optional.ofNullable(userQuery.get(openId))
                .map((user) -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseThrow(() -> new Exception(message.getUserUsernameExist()));
    }

//    @GetMapping(path = "/login")
//    public ResponseEntity login(@RequestParam(name = "openId") String openId,
//                                           @RequestParam(name = "password") String password) throws Exception {
//
//        UserModel userModel = userQuery.get(openId);
//
//        return Optional.ofNullable(userQuery.get(openId)).map(user->{
//           if (StringTools.nonEquals(userModel.getPassword(), password)){
//               return new ResponseEntity<>(message.getUserPasswordError(), HttpStatus.OK);
//           }else{
//               return new ResponseEntity<>(message.getUserPasswordError(), HttpStatus.OK);
//           }
//        }).orElseThrow(() -> new Exception(""));
//    }
}
