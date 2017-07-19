package com.yyq.data.master.service;

import com.yyq.base.support.utils.MD5Util;
import com.yyq.data.master.domain.master.User;
import com.yyq.data.master.domain.master.UserExample;
import com.yyq.data.master.exception.UserException;
import com.yyq.data.master.repository.master.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@Service
public class UserService {

    private static final String DEFAULT_AVATAR = "../../assets/img/user2-160x160.jpg";
    private static final String DEFAULT_ADDRESS = "NOT_SET_ADDRESS";
    private static final String DEFAULT_NICKNAME = "NOT_SET_NICKNAME";

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User initializeUser(String mobile, String email, String password, String trueName) {

        User validUser = getUserByMobile(mobile);

        if (validUser == null) {
            Date now = new Date();
            User user = new User();
            user.setUsername(mobile)
                    .setPassword(MD5Util.encode(password))
                    .setMobile(mobile)
                    .setEmail(email)
                    .setAvatar(DEFAULT_AVATAR)
                    .setAddress(DEFAULT_ADDRESS)
                    .setNickName(DEFAULT_NICKNAME)
                    .setTrueName(trueName)
                    .setCreateTime(now)
                    .setUpdateTime(now);
            userMapper.insertSelectiveAndGetKey(user);
            return user;
        } else {
            throw new UserException(500, "The user already exists");
        }
    }

    public User getUserByMobile(String mobile) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andMobileEqualTo(mobile);
        List<User> users = userMapper.selectByExample(userExample);

        return !users.isEmpty() ? users.get(0) : null;
    }
}
