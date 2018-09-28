package com.example.demo.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = new User(userName, new BCryptPasswordEncoder().encode("xx"), AuthorityUtils.commaSeparatedStringToAuthorityList("server"));
        if("admin".equals(userName)) {
            user = new User(userName, new BCryptPasswordEncoder().encode("xx"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
        return user;
    }
}
