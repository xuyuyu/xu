package com.offcn.service.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProductDaoImpl;
import com.offcn.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao dao = new ProductDaoImpl();

    public List<Product> getAllProduct() {
        return dao.findAllProduct();
    }

    @Override
    public List<Product> getAllReMenProduct() {
        return dao.findAllReMenProduct();
    }

    @Override
    public List<Product> getAllYouXuanProduct() {
        return dao.findAllYouXuanProduct();
    }

    @Override
    public Product getProductById(int productId) {
        return dao.findProductById(productId);
    }
}
