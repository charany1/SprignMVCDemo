package com.gfg.yogi.SpringMVCDemo.data;

import com.gfg.yogi.SpringMVCDemo.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDataMap {

    public static Map<Long, User> userData = new HashMap<>();

    static {

        User user0 = new User(0L,"Rod","Johnson");
        User user1 = new User(1L , "Eric", "Evans");
        User user2 = new User(2L,"Bill","Gates");
        User user3 = new User(3L,"Nelson","Mandela");

        userData.put(user0.getId(),user0);
        userData.put(user1.getId(),user1);
        userData.put(user2.getId(),user2);
        userData.put(user3.getId(),user3);

    }

}
