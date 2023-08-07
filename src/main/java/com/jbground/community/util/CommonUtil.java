package com.jbground.community.util;

public class CommonUtil {

    public static String findObjectAddress(Object o){
        return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
    }
}
