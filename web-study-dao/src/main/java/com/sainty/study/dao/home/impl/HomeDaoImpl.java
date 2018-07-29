package com.sainty.study.dao.home.impl;

import com.sainty.study.dao.BaseDao;
import com.sainty.study.dao.home.HomeDao;
import com.sainty.study.domain.home.User;
import org.springframework.stereotype.Component;

/**
 * Created by cdyujing7 on 2018/7/29.
 */
@Component("homeDao")
public class HomeDaoImpl extends BaseDao implements HomeDao{

    @Override
    public User queryUserInfoByName(String name) {
        return selectOne("User.selectUserByName", name);
    }

    @Override
    public int insertUser(User user) {
        return insert("User.insertUser", user);
    }

}
