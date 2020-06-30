package com.offcn.dao;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findAllProduct();  // 查询全部商品

    public List<Product> findAllReMenProduct();  //查询热门商品

    public List<Product> findAllYouXuanProduct(); //查询优选商品

    public Product findProductById(int productId); //根据id查询商品信息

}
