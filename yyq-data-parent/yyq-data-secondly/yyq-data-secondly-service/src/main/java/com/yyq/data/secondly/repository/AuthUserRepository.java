package com.yyq.data.secondly.repository;

import com.yyq.data.secondly.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yangyunqi on 2017/7/19.
 */
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    AuthUser findByUsername(String username);
}