package com.sainty.study.test.dao.home;

import com.sainty.study.dao.home.HomeDao;
import com.sainty.study.domain.home.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by cdyujing7 on 2018/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-config.xml"})
public class HomeDaoTest  {

    @Resource
    private HomeDao homeDao;

    @Test
    public void insertUser_test() {
        User user = new User();
        user.setName("sainty");
        user.setAge(28);
        user.setGender(1);
        user.setPhone("17360063818");
        user.setEmail("562061032@qq.com");
        Assert.isTrue(homeDao.insertUser(user) > 0);
    }

    @Test
    public void queryUser_test() {
        Assert.notNull(homeDao.queryUserInfoByName("sainty"));
    }
}
