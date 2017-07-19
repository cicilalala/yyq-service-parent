package com.yyq.data.secondly.web;

import com.yyq.data.secondly.domain.AuthUser;
import com.yyq.data.secondly.service.AuthUserService;
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
@RequestMapping("authUsers")
@Api(value = "认证用户", description = "认证用户")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @RequestMapping(value = "initializeAuthUser", method = RequestMethod.GET)
    @ApiOperation(value = "初始化认证用户", httpMethod = "GET", response = AuthUser.class, notes = "初始化认证用户")
    public AuthUser initializeAuthUser(@RequestParam("username") String username, @RequestParam("password") String password,
                                       @RequestParam("nickName") String nickName, @RequestParam("avatar") String avatar) {
        return authUserService.initializeAuthUser(username, password, nickName, avatar);
    }

    @RequestMapping(value = "findByUsername", method = RequestMethod.GET)
    @ApiOperation(value = "通过用户名获取用户", httpMethod = "GET", response = AuthUser.class, notes = "通过用户名获取用户")
    public AuthUser findByUsername(@RequestParam("username") String username) {
        return authUserService.findByUsername(username);
    }
}
