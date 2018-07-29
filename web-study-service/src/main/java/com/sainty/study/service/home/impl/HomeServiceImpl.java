package com.sainty.study.service.home.impl;

import com.sainty.study.dao.home.HomeDao;
import com.sainty.study.domain.home.User;
import com.sainty.study.service.home.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cdyujing7 on 2018/7/29.
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeDao homeDao;

    @Override
    public User queryBloggerInfo(String name) {
        return homeDao.queryUserInfoByName(name);
    }
}
