package com.tsaipenny.springbootmall.service;

import com.tsaipenny.springbootmall.dto.CreateOrderRequest;
import com.tsaipenny.springbootmall.model.Order;
import jakarta.validation.constraints.NotEmpty;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
