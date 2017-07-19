package com.yyq.data.master.repository.master;

import com.yyq.base.api.repository.BaseMapper;
import com.yyq.data.master.domain.master.User;
import com.yyq.data.master.domain.master.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User, UserExample, Long> {
    int insertSelectiveAndGetKey(User user);
}