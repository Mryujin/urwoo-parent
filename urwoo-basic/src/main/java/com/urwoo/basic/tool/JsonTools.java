package com.urwoo.basic.tool;

import com.google.gson.Gson;

public class JsonTools {

    public static String toJsonStr(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
