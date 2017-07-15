package com.urwoo.basic.tool;

import java.util.Objects;

public class ObjectTools {

    public static boolean isNull(Object object){
        return Objects.isNull(object);
    }

    public static boolean nonNull(Object object){
        return Objects.nonNull(object);
    }

    public static boolean equals(Object a, Object b){
        return Objects.equals(a, b);
    }

    public static boolean nonEquals(Object a, Object b){
        return !equals(a, b);
    }

    public static boolean deepEquals(Object a, Object b){
        return Objects.deepEquals(a, b);
    }

    public static String toString(Object o) {
        return Objects.toString(o, "null");
    }
}
