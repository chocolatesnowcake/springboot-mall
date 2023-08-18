package com.tsaipenny.springbootmall.dao;

import com.tsaipenny.springbootmall.dto.UserRegisterRequest;
import com.tsaipenny.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
    User getUserByEmail(String email);
}
