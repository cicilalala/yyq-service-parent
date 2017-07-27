package com.yyq.data.master.repository.master;

import com.yyq.base.api.repository.BaseMapper;
import com.yyq.data.master.domain.master.User;
import com.yyq.data.master.domain.master.UserRole;
import com.yyq.data.master.domain.master.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends BaseMapper<UserRole, UserRoleExample, Long> {
    int insertSelectiveAndGetKey(UserRole userRole);
}