package com.yyq.data.secondly.domain;

import com.yyq.base.api.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yangyunqi on 2017/7/19.
 */
@Entity
public class AuthUserRole extends BaseModel<AuthUserRole> {

    private static final long serialVersionUID = 7956356911466114418L;

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    public AuthUserRole() {
    }

    public AuthUserRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
