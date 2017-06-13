package com.next.web.controller;

import com.next.entity.User;
import com.next.feign.UserFeignClient;
import com.next.feign.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-06-12 17:45
 *
 * @author nextyu
 */
@RestController
public class FeignHystrixController {

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("/feignHystrix/{id}")
    public User getById(@PathVariable Long id) {
        return userFeignHystrixClient.getById(id);
    }
}
