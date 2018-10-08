package com.example.demo.controller;

import com.example.demo.po.MyUser;
import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    MyService myService;

    @RequestMapping("/xxx")
    public String xxx(String username, String password, HttpSession session){


        return "xxx" + " : " + session.getId();
    }

    @RequestMapping("/xx")
    public String xx(String username, String password, HttpSession session){

        return "xx"+ " : " + session.getId();
    }

    @RequestMapping("/x")
    public String x(String username, String password, HttpSession session){

        return "x"+ " : " + session.getId();
    }

    @RequestMapping("/xxxx")
    public String xxxx(String username, String password, HttpSession session){

        return "xxxx"+ " : " + session.getId();
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){

        return "login"+ " : " + session.getId();
    }

    @RequestMapping("/queryUser")
    public List<MyUser> queryUser(String username, String password, HttpSession session){

        MyUser myUser = new MyUser();
        myUser.setUsername("liuxg");
        List<MyUser> myUsers = new ArrayList<>();
        myUsers.add(myUser);
        return myService.queryUser(myUsers);
    }


}
