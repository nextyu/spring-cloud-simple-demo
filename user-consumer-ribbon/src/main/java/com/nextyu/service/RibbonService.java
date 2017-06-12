package com.nextyu.service;

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
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public User getById(Long id) {
        return restTemplate.getForObject("http://user-service/users/" + id, User.class);
    }
}
