package com.nextyu.service.impl;

import com.nextyu.dao.UserMapper;
import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 2017-05-26 11:01
 *
 * @author nextyu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.list();
    }

    @Override
    public void save(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
