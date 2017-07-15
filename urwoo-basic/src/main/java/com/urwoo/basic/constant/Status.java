package com.urwoo.basic.constant;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    OFF(0, "暂停"),
    ON(1, "启动"),
    DEL(2, "删除");

    private static Map<Integer, Status> map = new HashMap<>();
    static {
        for (Status status : Status.values()){
            map.put(status.code, status);
        }
    }

    private int code;
    private String des;

    Status(int code, String des){
        this.code = code;
        this.des = des;
    }

    public int code(){
        return code;
    }

    public String des(){
        return des;
    }

    public Status name(int code) {
        return map.get(code);
    }
}
