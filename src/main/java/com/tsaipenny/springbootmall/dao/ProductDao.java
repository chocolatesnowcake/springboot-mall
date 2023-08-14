package com.tsaipenny.springbootmall.dao;

import com.tsaipenny.springbootmall.model.Product;

import java.util.Map;

public interface ProductDao {
    Product getProductById(Integer productId);

}
