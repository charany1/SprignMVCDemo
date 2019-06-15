package com.gfg.yogi.SpringMVCDemo.controller;


import com.gfg.yogi.SpringMVCDemo.data.UserDataMap;
import com.gfg.yogi.SpringMVCDemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping(value = "/users")
    public  List<User> getUsers(){

        List<User> users = new ArrayList<>();

        Map<Long,User> userDataMap = UserDataMap.userData;

        for(Map.Entry<Long,User> userEntry: userDataMap.entrySet()){
            users.add(userEntry.getValue());
        }


        return users;
    }


}
