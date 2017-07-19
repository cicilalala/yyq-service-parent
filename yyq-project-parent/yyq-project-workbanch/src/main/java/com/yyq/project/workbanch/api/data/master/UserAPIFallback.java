package com.yyq.project.workbanch.api.data.master;

import com.yyq.data.master.domain.master.User;
import org.springframework.stereotype.Component;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@Component
public class UserAPIFallback implements UserAPI {

    @Override
    public User initializeUser(String mobile, String email, String password, String trueName) {
        return null;
    }

    @Override
    public User getUserByMobile(String mobile) {
        return null;
    }
}
