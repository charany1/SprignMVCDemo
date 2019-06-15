package com.gfg.yogi.SpringMVCDemo.controller;


import com.gfg.yogi.SpringMVCDemo.data.UserDataMap;
import com.gfg.yogi.SpringMVCDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired UserDataMap userDataMap;
    Map<Long,User> userData = UserDataMap.userData;

    @GetMapping(value = "/users")
    public  List<User> getUsers(){

        List<User> users = new ArrayList<>();



        for(Map.Entry<Long,User> userEntry: userData.entrySet()){
            users.add(userEntry.getValue());
        }


        return users;
    }


    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        User user = userData.get(id);
        return user;
    }
}
