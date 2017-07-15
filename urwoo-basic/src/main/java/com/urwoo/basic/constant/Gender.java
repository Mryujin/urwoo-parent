package com.urwoo.basic.constant;

import java.util.HashMap;
import java.util.Map;

public enum Gender {

    MALE(0, "女"),
    FEMALE(1, "男"),
    UNKNOW(2, "未知");

    private static Map<Integer, Gender> map = new HashMap<>();

    static {
        for (Gender gender : Gender.values()){
            map.put(gender.code, gender);
        }
    }

    private int code;
    private String des;

    Gender(int code, String des){
        this.code = code;
        this.des = des;
    }

    public int code(){
        return code;
    }

    public String des(){
        return des;
    }

    public Gender name(int code) {
        return map.get(code);
    }
}
