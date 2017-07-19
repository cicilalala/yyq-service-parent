package com.yyq.project.workbanch.api.data.secondly;

import com.yyq.data.secondly.domain.AuthUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@FeignClient(value = "yyq-data-secondly", path = "authUsers", fallback = AuthUserAPIFallback.class)
public interface AuthUserAPI {

    @RequestMapping(value = "initializeAuthUser", method = RequestMethod.GET)
    AuthUser initializeAuthUser(@RequestParam("username") String username, @RequestParam("password") String password,
                                @RequestParam("nickName") String nickName, @RequestParam("avatar") String avatar);

    @RequestMapping(value = "findByUsername", method = RequestMethod.GET)
    AuthUser findByUsername(@RequestParam("username") String username);
}
