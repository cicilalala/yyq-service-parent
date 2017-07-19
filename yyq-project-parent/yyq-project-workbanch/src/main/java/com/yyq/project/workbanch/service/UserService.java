package com.yyq.project.workbanch.service;

import com.yyq.data.master.domain.master.User;
import com.yyq.data.secondly.domain.AuthUser;
import com.yyq.project.workbanch.api.data.master.UserAPI;
import com.yyq.project.workbanch.api.data.secondly.AuthUserAPI;
import com.yyq.project.workbanch.dto.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by yangyunqi on 2017/7/19.
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthUserAPI authUserAPI;

    @Autowired
    private UserAPI userAPI;

    public User insertUser(String mobile, String email, String password, String trueName) {
        User user = userAPI.initializeUser(mobile, email, password, trueName);
        if (user != null) {
            authUserAPI.initializeAuthUser(user.getUsername(), user.getPassword(), user.getNickName(), user.getAvatar());
        }
        return user;
    }

    public User getUserByMobile(String mobile) {
        return userAPI.getUserByMobile(mobile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserAPI.findByUsername(username);
        if (authUser != null) {
            return new SecurityUser(authUser.getUsername(), authUser.getPassword(), authUser.getAuthUserRoles());
        } else {
            throw new UsernameNotFoundException("Username Not Found!");
        }
    }
}
