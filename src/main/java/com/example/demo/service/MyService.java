package com.example.demo.service;

import com.example.demo.po.MyUser;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyService {

    @PreAuthorize("hasAnyAuthority('server','admin') && #myUsers.size() > 0")
    @PreFilter("hasPermission(#myUsers,'xxdddd')")
    @PostFilter("")
    @PostAuthorize("")
    public List<MyUser> queryUser(List<MyUser> myUsers) {
        System.out.println(myUsers.size());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MyUser> list = new ArrayList<>();
        MyUser myUser = new MyUser();
        myUser.setUsername(userDetails.getUsername());
        list.add(myUser);
        return list;
    }
}
