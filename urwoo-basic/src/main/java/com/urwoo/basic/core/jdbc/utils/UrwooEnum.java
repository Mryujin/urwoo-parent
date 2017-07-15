package com.urwoo.basic.core.jdbc.utils;

public interface UrwooEnum<T> {

    int code();

    String des();

    T name(int code);
}
