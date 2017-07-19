package com.yyq.data.master.web;

import com.yyq.data.master.domain.master.User;
import com.yyq.data.master.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "initializeUser", method = RequestMethod.GET)
    @ApiOperation(value = "初始化用户", httpMethod = "GET", response = User.class, notes = "初始化用户")
    public User initializeUser(@RequestParam("mobile") String mobile, @RequestParam("email") String email,
                               @RequestParam("password") String password, @RequestParam("trueName") String trueName) {
        return userService.initializeUser(mobile, email, password, trueName);
    }

    @RequestMapping(value = "getUserByMobile", method = RequestMethod.GET)
    @ApiOperation(value = "通过手机号获取用户", httpMethod = "GET", response = User.class, notes = "通过手机号获取用户")
    public User getUserByMobile(@RequestParam("mobile") String mobile) {
        return userService.getUserByMobile(mobile);
    }
}
