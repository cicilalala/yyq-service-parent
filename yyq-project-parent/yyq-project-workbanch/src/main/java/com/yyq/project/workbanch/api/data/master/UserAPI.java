package com.yyq.project.workbanch.api.data.master;

import com.yyq.data.master.domain.master.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@FeignClient(value = "yyq-data-master", path = "users", fallback = UserAPIFallback.class)
public interface UserAPI {

    @RequestMapping(value = "initializeUser", method = RequestMethod.GET)
    User initializeUser(@RequestParam("mobile") String mobile, @RequestParam("email") String email,
                        @RequestParam("password") String password, @RequestParam("trueName") String trueName);

    @RequestMapping(value = "getUserByMobile", method = RequestMethod.GET)
    User getUserByMobile(@RequestParam("mobile") String mobile);
}
