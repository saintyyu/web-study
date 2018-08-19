package com.sainty.study.util;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by cdyujing7 on 2018/8/19.
 */
public class LocalCache implements Cache {

    private com.google.common.cache.Cache<String, Object> cache = null;

    private String prefix;
    private long timeout;

    @Override
    public String getName() {
        return this.prefix;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        Object var = getFromLocalCache(this.prefix + key.toString(), timeout);
        return var == null ? null : new SimpleValueWrapper(var);
    }

    @Override
    public void put(Object key, Object value) {
        if (value == null) {
            return;
        }
        putToLocalCache(this.prefix + key.toString(), value, timeout);
    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }



    public com.google.common.cache.Cache<String, Object> getCache(long timeout) {
        if (cache == null) {//懒汉式
            synchronized (this) {
                if (cache == null) {
                    cache = CacheBuilder.newBuilder()
                            .expireAfterWrite(timeout, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return cache;
    }


    public Object getFromLocalCache(String key, long timeout) {
        Optional optional = Optional.fromNullable(getCache(timeout).getIfPresent(key));
        return optional.orNull();
    }

    public void putToLocalCache(String key, Object object, long timeout) {
        getCache(timeout).put(key, object);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
