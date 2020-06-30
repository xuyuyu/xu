package com.offcn.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFirstFilter implements Filter {
    // 初始化方法，在Filter对象被创建时自动调用
    /*
    * Servlet对象是第一次访问时，服务器创建
    * Filter对象是服务器启动时，服务器负责创建Filter的对象，并调用init方法一次！！！
    * */
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFirstFilter出生了...");
    }

    // 过滤，根据需求，反复执行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFirstFilter...doFilter...");
    }

    //销毁   在Filter对象被销毁时，自动调用
    // Filter对象在服务器关闭时销毁，销毁前执行detroy方法一次
    public void destroy() {
        System.out.println("MyFirstFilter升天了###");
    }
}
