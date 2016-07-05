package com.hsy.codebase.utils.javase.beanUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @description 
 *     <p>比较两个类属性数据是否相同</p>
 * @time 2016年4月4日 上午11:01:52
 */
public class BeanCompare {
    public static <T> Map<String, String> compare(T obj1, T Obj2)
            throws Exception {

        Map<String, String> result = new HashMap<String, String>();

        Field[] fs = obj1.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            Object v1 = f.get(obj1);
            Object v2 = f.get(Obj2);
            if (equals(v1, v2) == Boolean.FALSE) {
                result.put(f.getName(), (String) v1);
            }
        }
        return result;
    }

    public static boolean equals(Object obj1, Object obj2) {

        if (obj1 == obj2) {
            return true;
        } else if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }
}