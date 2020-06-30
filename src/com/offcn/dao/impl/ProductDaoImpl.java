package com.offcn.dao.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    // 查询全部商品
    public List<Product> findAllProduct(){
        List<Product> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from product";
        try {
            list = qr.query(sql,new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findAllReMenProduct() {
        List<Product> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from product where pro_state=1" ;
        try {
            list = qr.query(sql,new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findAllYouXuanProduct() {
        List<Product> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from product where pro_state=2" ;
        try {
            list = qr.query(sql,new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findProductById(int productId) {

        Product product = null;

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from product where pro_id=?";

        try {
            product = qr.query(sql,new BeanHandler<>(Product.class),productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
