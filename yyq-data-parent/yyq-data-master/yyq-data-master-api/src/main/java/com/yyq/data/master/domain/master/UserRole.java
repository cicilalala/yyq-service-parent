package com.yyq.data.master.domain.master;

import com.yyq.base.api.model.BaseModel;

public class UserRole extends BaseModel<UserRole> {
    private static final long serialVersionUID = -2139519340123618992L;
    private Long id;

    private Long userId;

    private String roleName;

    public UserRole(Long id, Long userId, String roleName) {
        this.id = id;
        this.userId = userId;
        this.roleName = roleName;
    }

    public UserRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public UserRole setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
        return this;
    }
}