package com.urwoo.basic.constant;

import java.util.HashMap;
import java.util.Map;

public enum Level {
    ONE(1, "");

    private static Map<Integer, Level> map = new HashMap<>();

    static {
        for (Level level : Level.values()){
            map.put(level.code, level);
        }
    }

    private int code;
    private String des;

    Level(int code, String des){
        this.code = code;
        this.des = des;
    }

    public int code(){
        return code;
    }

    public String des(){
        return des;
    }

    public Level name(int code) {
        return map.get(code);
    }
}
