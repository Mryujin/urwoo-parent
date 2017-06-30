package com.urwoo.basic.constant;

public enum Status {
    OFF(0, "暂停"),
    ON(1, "启动"),
    DEL(2, "删除");

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
}
