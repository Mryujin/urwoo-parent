package com.urwoo.basic.constant;

import java.util.HashMap;
import java.util.Map;

public enum LoginType {

    LOGIN_UI(0, "登录页面登录"),
    QQ(1, "qq授权登录"),
    WEIBO(2, "微博登录"),
    WEIXIN(3, "微信登录");

    private static Map<Integer, LoginType> map = new HashMap<>();
    static {
        for (LoginType userType : LoginType.values()){
            map.put(userType.code, userType);
        }
    }

    private int code;
    private String des;

    LoginType(int code, String des){
        this.code = code;
        this.des = des;
    }

    public int code() {
        return 0;
    }

    public String des() {
        return null;
    }

    public LoginType name(int code) {
        return map.get(code);
    }
}
