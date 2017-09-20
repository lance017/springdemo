package com.lance.springdemo;

import com.lance.springdemo.dao.UserMapper;
import com.lance.springdemo.po.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Test;

/**
 * Created by lance on 2017/9/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
@ContextConfiguration("classpath:spring-config.xml")
public class Stest {

    @Autowired(required = false)
    private UserMapper userMapper;

    @org.junit.Test
    public void findCountTest() {
        User user = new User();
        user.setAge(12);
        user.setId(11);
        user.setName("lance");
        user.setRecommend("sdfdgf");
        int count = userMapper.insert(user);
        System.out.println(count);
    }

}
