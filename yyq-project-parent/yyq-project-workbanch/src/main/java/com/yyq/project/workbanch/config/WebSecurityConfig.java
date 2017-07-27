package com.yyq.project.workbanch.config;

import com.yyq.project.workbanch.service.UserService;
import com.yyq.project.workbanch.utils.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by yangyunqi on 2017/7/5.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMINISTRATOR = "ADMIN";
    private static final String USER = "USER";
    private static final String VISTOR = "VISTOR";

    @Bean
    UserDetailsService customUserDetailsService(){
        return new UserService();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置Spring Security的Filter链
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置如何通过拦截器保护请求

//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(2419200)
//                .key("authKey")
//                .and()
//                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用内存用户存储
        auth.inMemoryAuthentication()
                .withUser("root").password("admin123").roles(ADMINISTRATOR)
                .and()
                .withUser("demoUser").password("admin123").roles(USER);
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(new StandardPasswordEncoder());
    }

}
