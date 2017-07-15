package com.urwoo.basic.tool;

public class StringTools {

    public static boolean isNullOrEmpty(final String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotNullAndEmpty(final String str){
        return !isNullOrEmpty(str);
    }

    public static boolean equals(final String a, final String b){
        return a == b || null != a && a.equals(b);
    }

    public static boolean nonEquals(final String a, final String b){
        return !equals(a, b);
    }
}
