package com.offcn.service;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();

    public List<Product> getAllReMenProduct();

    public List<Product> getAllYouXuanProduct();

    public Product getProductById(int productId);
}
