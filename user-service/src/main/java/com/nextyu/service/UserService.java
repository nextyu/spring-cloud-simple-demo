package com.nextyu.service;

import com.nextyu.domain.User;

import java.util.List;

/**
 * created on 2017-05-26 10:59
 *
 * @author nextyu
 */
public interface UserService {
    List<User> listAll();

    void save(User user);

    User getById(Long id);

    void update(User user);

    void deleteById(Long id);
}
