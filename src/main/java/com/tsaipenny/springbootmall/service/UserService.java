package com.tsaipenny.springbootmall.service;

import com.tsaipenny.springbootmall.dto.UserLoginRequest;
import com.tsaipenny.springbootmall.dto.UserRegisterRequest;
import com.tsaipenny.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
    User login(UserLoginRequest userLoginRequest);

}
