package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class Controller {

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
}
