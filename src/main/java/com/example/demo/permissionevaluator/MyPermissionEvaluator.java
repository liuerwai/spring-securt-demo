package com.example.demo.permissionevaluator;

import com.example.demo.po.MyUser;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class MyPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetObject, Object permission) {

        if(targetObject instanceof MyUser){
            MyUser myUser = (MyUser) targetObject;
            if(myUser.getUsername().equals("liuxg")){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
