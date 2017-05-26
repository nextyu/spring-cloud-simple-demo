package com.nextyu.web.controller;

import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-05-25 17:19
 *
 * @author nextyu
 */
@Api(value = "用户API", tags = "用户API")
@RequestMapping("/users")
@RestController
public class UserController {

    @Value("${haha}")
    public String haha;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = User.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    public Object list() {

        System.out.println(haha + "-------------------------------------");

        return userService.listAll();
    }
}
