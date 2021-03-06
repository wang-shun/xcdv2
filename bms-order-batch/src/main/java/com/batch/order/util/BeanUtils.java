package com.batch.order.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 封装bean copy
 * 
 * @author li_huiqian
 *
 */
public class BeanUtils {

    /**
     * 严格的bean copy
     * 
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        try {
            PropertyUtils.copyProperties(target, source);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
