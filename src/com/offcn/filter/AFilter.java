package com.offcn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/SessionTest7Servlet")
public class AFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("AFilter...begin...");
        chain.doFilter(req, resp);                       //责任链模式
        System.out.println("AFilter...end...");

        // 转换流   适配器模式
        // 缓存流   装饰者模式
        // 比较器 Comparator   策略模式
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
