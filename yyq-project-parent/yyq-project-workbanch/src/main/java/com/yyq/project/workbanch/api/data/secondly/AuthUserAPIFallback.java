package com.yyq.project.workbanch.api.data.secondly;

import com.yyq.data.secondly.domain.AuthUser;
import org.springframework.stereotype.Component;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@Component
public class AuthUserAPIFallback implements AuthUserAPI {

    @Override
    public AuthUser initializeAuthUser(String userName, String password, String nickName, String avatar) {
        return null;
    }

    @Override
    public AuthUser findByUsername(String userName) {
        return null;
    }
}
