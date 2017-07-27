package com.yyq.data.master.service;

import com.yyq.base.support.utils.MD5Util;
import com.yyq.data.master.domain.master.User;
import com.yyq.data.master.domain.master.UserExample;
import com.yyq.data.master.domain.master.UserRole;
import com.yyq.data.master.domain.master.UserRoleExample;
import com.yyq.data.master.exception.UserException;
import com.yyq.data.master.repository.master.UserMapper;
import com.yyq.data.master.repository.master.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
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

    private static final String ADMINISTRATOR = "ADMIN";
    private static final String USER = "USER";
    private static final String VISTOR = "VISTOR";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Transactional
    public User initializeUser(String mobile, String email, String password, String trueName) {

        User validUser = getUserByMobile(mobile);

        if (validUser == null) {
            Date now = new Date();
            User user = new User();
            user.setUsername(mobile)
                    .setPassword(password)
                    .setMobile(mobile)
                    .setEmail(email)
                    .setAvatar(DEFAULT_AVATAR)
                    .setAddress(DEFAULT_ADDRESS)
                    .setNickName(DEFAULT_NICKNAME)
                    .setTrueName(trueName)
                    .setCreateTime(now)
                    .setUpdateTime(now);
            userMapper.insertSelectiveAndGetKey(user);

            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId()).setRoleName(VISTOR);
            userRoleMapper.insertSelectiveAndGetKey(userRole);

            user.setRoles(Collections.singletonList(userRole));
            return user;
        } else {
            throw new UserException(500, "The user already exists");
        }
    }

    public User getUserByMobile(String mobile) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andMobileEqualTo(mobile);
        List<User> users = userMapper.selectByExample(userExample);

        User user = !users.isEmpty() ? users.get(0) : null;

        if (!users.isEmpty()) {
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(users.get(0).getId());
            List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
            user.setRoles(userRoles);
        }
        return user;
    }
}
