package com.tsaipenny.springbootmall.dao;

import com.tsaipenny.springbootmall.dto.ProductRequest;
import com.tsaipenny.springbootmall.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    List<Product> getProducts();
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void  deleteProductById(Integer productId);
}
