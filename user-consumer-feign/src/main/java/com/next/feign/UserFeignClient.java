package com.next.feign;

import com.next.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created on 2017-06-12 17:09
 *
 * @author nextyu
 */
@FeignClient(name = "user-service")
public interface UserFeignClient {
    @RequestMapping("/users/{id}")
    User getById(@RequestParam("id") Long id);
}
