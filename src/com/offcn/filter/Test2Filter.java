package com.offcn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/SessionTest5Servlet")  //过滤具体路径(过滤Servlet的方法路径)
//@WebFilter(servletNames = {"Sess5Servlet"}) // 根据Servlet的name进行过滤
public class Test2Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Test2Filter######");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
