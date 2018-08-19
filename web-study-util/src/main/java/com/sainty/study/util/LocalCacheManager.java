package com.sainty.study.util;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by cdyujing7 on 2018/8/19.
 */
public class LocalCacheManager extends AbstractCacheManager {

    private Collection<? extends Cache> caches;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    protected Collection<? extends Cache> loadCaches() {
        return (Collection<? extends Cache>)(caches == null ? Collections.emptyList() : caches);
    }

    public void setCaches(Collection<? extends Cache> caches) {
        this.caches = caches;
    }
}
