package com.next.feign;

import com.next.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * created on 2017-06-12 17:09
 *
 * @author nextyu
 */
@FeignClient(name = "user-service", fallback = UserFeignHystrixClient.UserFeignHystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @Component
    class UserFeignHystrixClientFallback implements UserFeignHystrixClient {
        @Override
        public User getById(Long id) {
            System.out.println("uuuuuuuuuuuuuuu");
            User user = new User();
            user.setId(-1L);
            user.setName("default name");
            return user;
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User getById(@PathVariable("id") Long id);
}
