package com.gateway.util;


import java.util.Collection;
import java.util.Map;

/**
 *
 */
public class ObjUtils {

    /**
     * 字符串为空
     * @param str
     * @return true
     */
    public static Boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 字符串不为空
     * @param str
     * @return true
     */
    public static Boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 集合为空
     * @param collection
     * @return true
     */
    public static Boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    /**
     * 对象为空
     * @param obj
     * @return true
     */
    public static Boolean isEmpty(Object obj) {
        return obj == null;
    }

    /**
     * map集合为空
     * @param map
     * @return true
     */
    public static Boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

}
