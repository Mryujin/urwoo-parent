package com.urwoo.basic.tool;

import java.util.Collection;
import java.util.Map;

public class MapTools {

    public static <K,V> boolean isNullOrEmpty(final Map<K,V> map){
        return null == map || map.isEmpty();
    }

    public static <K,V> boolean isNotNullAndEmpty(final Map<K,V> map){
        return null != map && !map.isEmpty();
    }
}
