package com.sainty.study.dao.home;

import com.sainty.study.domain.home.User;

/**
 * Created by cdyujing7 on 2018/7/29.
 */
public interface HomeDao {

    User queryUserInfoByName(String name);

    int insertUser(User user);
}
