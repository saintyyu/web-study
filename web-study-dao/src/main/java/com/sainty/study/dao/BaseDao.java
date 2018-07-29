package com.sainty.study.dao;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by cdyujing7 on 2018/7/29.
 */
public abstract class BaseDao extends SqlSessionDaoSupport {

    protected <T> int insert(String sqlId, T param) {
        try {
            return getSqlSession().insert(sqlId, param);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected <T> int delete(String sqlId, T param) {
        try {
            return getSqlSession().delete(sqlId, param);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected <T> int update(String sqlId, T param) {
        try {
            return getSqlSession().update(sqlId, param);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected <T> T selectOne(String sqlId, Object param) {
        try {
            return getSqlSession().selectOne(sqlId, param);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T> List<T> selectList(String sqlId) {
        try {
            return getSqlSession().selectList(sqlId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T> List<T> selectList(String sqlId, Object param) {
        try {
            return getSqlSession().selectList(sqlId, param);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
