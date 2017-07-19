package com.yyq.data.master.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

//    @Test
//    public void selectById() throws Exception {
//        User user = userService.selectById(34L);
//        log.info(user.toJSONString());
//    }

}