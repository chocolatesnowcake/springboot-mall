package com.tsaipenny.springbootmall.service;

import com.tsaipenny.springbootmall.dto.CreateOrderRequest;
import jakarta.validation.constraints.NotEmpty;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
