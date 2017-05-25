package com.nextyu.web.controller;

import com.nextyu.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2017-05-25 17:19
 *
 * @author nextyu
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Value("${haha}")
    public String haha;

    @RequestMapping("/list")
    public Object list() {
        List<User> users = new ArrayList<>();
        User user = new User(1L, "小明");
        User user2 = new User(1L, "小黑");
        User user3 = new User(1L, "小花");
        users.add(user);
        users.add(user2);
        users.add(user3);

        System.out.println(haha+"-------------------------------------");

        return users;
    }
}
