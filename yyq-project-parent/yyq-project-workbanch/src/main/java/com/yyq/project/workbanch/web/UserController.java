package com.yyq.project.workbanch.web;

import com.yyq.base.support.dto.Result;
import com.yyq.base.support.utils.ResultUtil;
import com.yyq.project.workbanch.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyunqi on 2017/7/19.
 */

@RestController
@RequestMapping("users")
@Api(value = "用户", description = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    @ApiOperation(value = "初始化用户", httpMethod = "GET", response = Result.class, notes = "初始化用户")
    public Result insertUser(@RequestParam("mobile") String mobile, @RequestParam("email") String email,
                                     @RequestParam("password") String password, @RequestParam("trueName") String trueName) {
        return ResultUtil.success(userService.insertUser(mobile, email, password, trueName));
    }

    @RequestMapping(value = "getUserByMobile", method = RequestMethod.GET)
    @ApiOperation(value = "根据手机号获取用户", httpMethod = "GET", response = Result.class, notes = "根据手机号获取用户")
    public Result getUserByMobile(String mobile) {
        return ResultUtil.success(userService.getUserByMobile(mobile));
    }

    @RequestMapping(value = "loadUserByUsername", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获取认证用户", httpMethod = "GET", response = Result.class, notes = "根据用户名获取认证用户")
    public Result loadUserByUsername(String username) throws UsernameNotFoundException {
        return ResultUtil.success(userService.loadUserByUsername(username));
    }
}
