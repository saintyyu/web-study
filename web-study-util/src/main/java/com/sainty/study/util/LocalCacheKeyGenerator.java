package com.sainty.study.util;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * Created by cdyujing7 on 2018/8/19.
 */
public class LocalCacheKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(target.getClass().getName());
        keyBuilder.append(method.getName());
        for (Object param : params) {
            keyBuilder.append(param);
        }
        return keyBuilder.toString();
    }
}
