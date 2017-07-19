package com.yyq.data.secondly.repository;

import com.yyq.data.secondly.domain.AuthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yangyunqi on 2017/7/19.
 */
public interface AuthUserRoleRepository extends JpaRepository<AuthUserRole, Long> {

    AuthUserRole findByRole(String role);
}
