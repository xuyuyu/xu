package com.offcn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/aaa")
//@WebFilter(urlPatterns = {"/aaa","/bbb"})
public class MySecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("secondfilter出生了######");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MySecondFilter<<<>>>doFilter<<<>>>");
    }

    @Override
    public void destroy() {
        System.out.println("secondfilter升天了········");
    }
}
