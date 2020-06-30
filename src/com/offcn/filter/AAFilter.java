package com.offcn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/SessionTest7Servlet")
public class AAFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("AAFilter~~~begin~~~");
        chain.doFilter(req, resp);
        System.out.println("AAFilter~~~end~~~");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
