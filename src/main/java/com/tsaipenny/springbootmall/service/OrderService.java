package com.tsaipenny.springbootmall.service;

import com.tsaipenny.springbootmall.dto.CreateOrderRequest;
import com.tsaipenny.springbootmall.dto.OrderQueryParams;
import com.tsaipenny.springbootmall.model.Order;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public interface OrderService {
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer countOrder(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
