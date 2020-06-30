package com.offcn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(value = "/SessionTest7Servlet",dispatcherTypes ={DispatcherType.FORWARD} )
public class MyThirdFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("MyThirdFilter######");
        chain.doFilter(req,resp);  // 放行(只有一个过滤器时，放行到目标。有多个过滤器时，放行到下一个过滤)
        System.out.println("MyThirdFilterback<<<>>>");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
