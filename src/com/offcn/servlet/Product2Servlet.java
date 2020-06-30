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

@WebServlet("/Product2Servlet")
public class Product2Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
         String method = request.getParameter("method");

        if("findAllProduct".equals(method)){
            findAllProduct(request,response);
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

        request.getRequestDispatcher("jsp/showproduct2.jsp").forward(request,response);
    }
}
