package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.ProductService;
import com.offcn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Product3Servlet")
public class Product3Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        if("findAllProduct".equals(method)){
            findAllProduct(request,response);
        }else if("findProductById".equals(method)){
            findProductById(request,response);
        }
    }


    protected void findAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService service = new ProductServiceImpl();

        // 热门商品
        List<Product> remenList = service.getAllReMenProduct();

        // 优选商品
        List<Product> youxuanList = service.getAllYouXuanProduct();

        request.setAttribute("remenList",remenList);
        request.setAttribute("youxuanList",youxuanList);

        // 在showproduct3.jsp 使用EL表达式和JSTL标签库来展示数据，不使用java脚本
        request.getRequestDispatcher("jsp/showproduct3.jsp").forward(request,response);
    }

    protected void findProductById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取商品id
        String productId = request.getParameter("productId");

        ProductService service = new ProductServiceImpl();

        // 根据id查询到商品信息
        Product product = service.getProductById(Integer.parseInt(productId));

        // 把商品信息存入request作用域
        request.setAttribute("product",product);

        // 转发到商品详情页面
        request.getRequestDispatcher("jsp/product_info.jsp").forward(request,response);
    }
}
