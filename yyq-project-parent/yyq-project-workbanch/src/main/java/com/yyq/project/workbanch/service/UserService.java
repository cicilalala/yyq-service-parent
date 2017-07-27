package com.yyq.project.workbanch.service;

import com.yyq.data.master.domain.master.User;
import com.yyq.data.master.domain.master.UserRole;
import com.yyq.project.workbanch.api.data.master.UserAPI;
import com.yyq.project.workbanch.api.data.secondly.AuthUserAPI;
import com.yyq.project.workbanch.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by yangyunqi on 2017/7/19.
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthUserAPI authUserAPI;

    @Autowired
    private UserAPI userAPI;

    public User insertUser(String mobile, String email, String password, String trueName) {
        return userAPI.initializeUser(mobile, email, new StandardPasswordEncoder().encode(password), trueName);
    }

    public User getUserByMobile(String mobile) {
        return userAPI.getUserByMobile(mobile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAPI.getUserByMobile(username);

        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        if (user.getRoles() == null) {
            throw new UserException(500, "这个用户没有权限");
        }

        return new UserDetails() {

            private static final long serialVersionUID = 472211680460352677L;

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                for (UserRole role : user.getRoles()) {
                    authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                }
                return authorities;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
