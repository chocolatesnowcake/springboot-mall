package com.tsaipenny.springbootmall.service;

import com.tsaipenny.springbootmall.constant.ProductCategory;
import com.tsaipenny.springbootmall.dto.ProductRequest;
import com.tsaipenny.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductCategory category, String search);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
