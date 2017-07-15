package com.urwoo.basic.constant;

import java.util.HashMap;
import java.util.Map;

public enum Role {

    ADMIN(0, "ADMIN"),
    USER(1, "USER");

    private static Map<Integer, Role> map = new HashMap<>();
    static {
        for (Role role : Role.values()){
            map.put(role.code, role);
        }
    }

    private int code;
    private String des;

    Role(int code, String des){
        this.code = code;
        this.des = des;
    }

    public int code(){
        return code;
    }

    public String des(){
        return des;
    }

    public Role name(int code) {
        return map.get(code);
    }

}
