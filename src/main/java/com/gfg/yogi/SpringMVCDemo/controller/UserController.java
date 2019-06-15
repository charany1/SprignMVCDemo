package com.gfg.yogi.SpringMVCDemo.controller;


import com.gfg.yogi.SpringMVCDemo.data.UserDataMap;
import com.gfg.yogi.SpringMVCDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
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

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        userData.put(user.getId(),user);
        return userData.get(user.getId());
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id")Long id,@RequestBody User user){
        User currentUser = userData.get(id);
        System.out.println("Earlier user with id : "+id+ " is "+ currentUser);

        userData.put(id,user);

        return userData.get(id);
    }


}
