package com.urwoo.user.config.security;

import com.urwoo.basic.tool.ObjectTools;
import com.urwoo.user.config.message.Message;
import com.urwoo.user.domain.UserModel;
import com.urwoo.user.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrwooUserDetailsService implements UserDetailsService{

    @Autowired
    private UserQuery userQuery;
    @Autowired
    private Message message;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userQuery.get(username);
        if (ObjectTools.isNull(userModel)){
            throw new UsernameNotFoundException(message.getUserNotExist());
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(userModel.getRole().des());
        return new User(userModel.getUsername(), userModel.getPassword(), simpleGrantedAuthorities);
    }

    /**
     * 权限字符串转化
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     * @param roleStr 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }

}
