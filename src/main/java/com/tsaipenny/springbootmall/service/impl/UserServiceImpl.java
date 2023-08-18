package com.tsaipenny.springbootmall.service.impl;

import com.tsaipenny.springbootmall.dao.UserDao;
import com.tsaipenny.springbootmall.dto.UserRegisterRequest;
import com.tsaipenny.springbootmall.model.User;
import com.tsaipenny.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

}
