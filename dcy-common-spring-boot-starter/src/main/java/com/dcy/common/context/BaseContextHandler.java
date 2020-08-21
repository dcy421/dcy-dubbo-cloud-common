package com.dcy.common.context;


import com.dcy.common.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：dcy
 * @Description: 线程帮助类
 * @Date: 2019/9/6 13:34
 */
public class BaseContextHandler {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static void setUserID(String userID) {
        set(Constant.CONTEXT_KEY_USER_ID, userID);
    }

    public static String getUserID() {
        Object value = get(Constant.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static void setUsername(String username) {
        set(Constant.CONTEXT_KEY_USERNAME, username);
    }

    public static void setCurrentURL(String currentURL) {
        set(Constant.CONTEXT_KEY_URL, currentURL);
    }

    public static String getUsername() {
        Object value = get(Constant.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }

}
