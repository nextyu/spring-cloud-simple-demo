package com.nextyu.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nextyu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * created on 2017-06-12 16:57
 *
 * @author nextyu
 */
@Service
public class RibbonHystrixService {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallBack")
    public User getById(Long id) {
        return restTemplate.getForObject("http://user-service/users/" + id, User.class);
    }

    /**
     * hystrix fallback方法
     *
     * @param id
     * @return
     */
    public User fallBack(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default name");
        return user;
    }
}
