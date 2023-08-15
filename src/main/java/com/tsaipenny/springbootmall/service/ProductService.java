package com.tsaipenny.springbootmall.service;

import com.tsaipenny.springbootmall.dto.ProductRequest;
import com.tsaipenny.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
