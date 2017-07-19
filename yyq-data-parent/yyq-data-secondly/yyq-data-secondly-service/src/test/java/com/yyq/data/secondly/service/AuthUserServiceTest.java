package com.yyq.data.secondly.service;

import com.yyq.data.secondly.domain.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yangyunqi on 2017/7/19.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserServiceTest {

    @Autowired
    private AuthUserService authUserService;

    @Test
    public void initializeAuthUser() throws Exception {
        authUserService.initializeAuthUser("18519189497", "44bf025d27eea66336e5c1133c3827f7", "RickyYoung", "../../assets/img/user2-160x160.jpg");
    }

    @Test
    public void findByUserName() throws Exception {
        AuthUser authUser = authUserService.findByUsername("18519189497");
        log.info(authUser.toString());
    }

}