package com.yyq.data.master.domain.master;

import com.yyq.base.api.model.BaseModel;

import java.util.Date;
import java.util.List;

public class User extends BaseModel<User> {
    private static final long serialVersionUID = 8153529389025787235L;
    private Long id;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String address;

    private String trueName;

    private String nickName;

    private String avatar;

    private Date createTime;

    private Date updateTime;

    private List<UserRole> roles;

    public User(Long id, String username, String password, String mobile, String email, String address, String trueName, String nickName, String avatar, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.trueName = trueName;
        this.nickName = nickName;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public User setRoles(List<UserRole> roles) {
        this.roles = roles;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address == null ? null : address.trim();
        return this;
    }

    public String getTrueName() {
        return trueName;
    }

    public User setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public User setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}