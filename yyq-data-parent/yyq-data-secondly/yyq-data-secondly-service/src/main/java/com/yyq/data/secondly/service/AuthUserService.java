package com.yyq.data.secondly.service;

import com.yyq.data.secondly.domain.AuthUser;
import com.yyq.data.secondly.domain.AuthUserRole;
import com.yyq.data.secondly.exception.AuthUserException;
import com.yyq.data.secondly.repository.AuthUserRepository;
import com.yyq.data.secondly.repository.AuthUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Created by yangyunqi on 2017/7/19.
 */
@Service
public class AuthUserService {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private AuthUserRoleRepository authUserRoleRepository;

    @Transactional
    public AuthUser initializeAuthUser(String username, String password, String nickName, String avatar) {
        AuthUserRole userRole = authUserRoleRepository.findByRole(ROLE_USER);

        AuthUser validUser = findByUsername(username);

        if (validUser == null) {
            AuthUser authUser = new AuthUser();
            authUser.setUsername(username)
                    .setPassword(password)
                    .setNickName(nickName)
                    .setAvatar(avatar)
                    .setAuthUserRoles(Collections.singletonList(userRole));
            return authUserRepository.save(authUser);
        } else {
            throw new AuthUserException(500, "The user already exists");
        }

    }

    public AuthUser findByUsername(String username) {
        return authUserRepository.findByUsername(username);
    }
}
