package com.urwoo.basic.tool;

import java.util.Collection;

public class CollectionTools {

    public static <T> boolean isNullOrEmpty(final Collection<T> collection){
        return null == collection || collection.isEmpty();
    }

    public static <T> boolean isNotNullAndEmpty(final Collection<T> collection){
        return null != collection && !collection.isEmpty();
    }

}
