package com.yyq.data.secondly.domain;

import com.yyq.base.api.model.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yangyunqi on 2017/7/19.
 */
@Entity
public class AuthUser extends BaseModel<AuthUser> {

    private static final long serialVersionUID = 3223511322585889738L;

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String nickName;

    private String avatar;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<AuthUserRole> authUserRoles;

    public AuthUser() {
    }

    public AuthUser(String username, String password, String nickName, String avatar, List<AuthUserRole> authUserRoles) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.avatar = avatar;
        this.authUserRoles = authUserRoles;
    }

    public Long getId() {
        return id;
    }

    public AuthUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public AuthUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public AuthUser setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public List<AuthUserRole> getAuthUserRoles() {
        return authUserRoles;
    }

    public AuthUser setAuthUserRoles(List<AuthUserRole> authUserRoles) {
        this.authUserRoles = authUserRoles;
        return this;
    }
}
