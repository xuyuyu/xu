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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String method = request.getParameter("method");

        if("findAllProduct".equals(method)){
            findAllProduct(request,response);
        }

    }

    protected void findAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1 调用service查回数据
        ProductService service = new ProductServiceImpl();
        List<Product> list = service.getAllProduct();

        // 2 展示查询回的数据

/*
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<table border='1' width='500px'><tr><td>商品id</td><td>商品名称</td><td>商品图片</td>");
        for(Product p:list){
            out.println("<tr><td>"+p.getPro_id()+"</td><td>"+p.getPro_name()+"</td><td><img src='"+p.getPro_min_img()+"' /></td></tr>");
        }
        out.println("</table>");
*/

       // servlet可以完成展示数据的工作，但确定十分明显——拼接字符串的方式使用out进行输出，拼接过程过于繁琐。所以Servlet不适合用来展示数据。
       // 那么应该如何展示查询回的数据呢？  html做不到到（静态资源）。可以使用jsp：1、jsp是动态资源，可以动态改变(展示内容) 2、jsp写html标签十分简单

    /*
    * Servlet和jsp的对比：
    *
    *  servlet和jsp都是动态资源，可以完成相同的工作。但是有各自强项
    *
    *  Servlet 适合处理数据（获取数据，封装数据），调用后台代码，控制跳转流程----------> 控制器
    *  jsp 适合做页面展示
    *
    * */

         // 查询回的数据在Servlet中，如何使用jsp去展示呢？  就需要把servlet的数据，传到jsp中
         // 需要把list存到一个作用域中。
         /*
             Servlet中有三个作用域     request、session、ServletContext
             jsp中有四个作用域         pageContext request session application

             本案例中使用request作用域

         * */
         request.setAttribute("allProductList",list);  // 把list存入request作用域，并起名为allProductList
         //response.sendRedirect("jsp/showproduct.jsp"); // 使用重定向，在jsp中取不到数据。因为重定向是两次请求，两次响应，Servlet中的request和jsp中的request不是同一个request

         // 请求转发
        request.getRequestDispatcher("jsp/showproduct.jsp").forward(request,response);

        /*
        * 转发和重定向：
        *   转发和重定向都可以做跳转。
        *
        *   重定向： 1、两次请求两次响应。
        *           2、可以重定向到自己项目的其他路径，也可以重定向到其他项目的路径。
        *           3、重定向地址会变化
        *   转发： 1、一次请求一次响应
        *         2、转发只能转发到自己项目的其他路径，转发可以转发到WEB-INF目录下的受保护的资源
        *         3、转发时地址栏不变
        *
        *
        * 什么时候用转发？什么时候用重定向？
        *
        *    如果需要使用request作用域带值就必须用转发。
        *    如果要跳转到其他项目的页面必须用重定向。
        *    其他情况，用转发和重定向都可以。
        * */
        //request.getRequestDispatcher("WEB-INF/test.html").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
