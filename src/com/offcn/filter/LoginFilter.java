package com.offcn.filter;

import com.offcn.dao.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.offcn.bean.User;

@WebFilter(urlPatterns = {"/CartServlet","/PayServlet","/jsp/cart.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 如何判断是否登录过？？？    获取session,从session中查找user，如果找到了，说明登录了，没找到说明没登录
        /*
        * HttpServletRequest 是 ServletRequest的子接口
        * HttpServletResponse 是 ServletResponse的子接口
        * */
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if(user==null){ // 没登录过，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/jsp/login.jsp?msg=pleaselogin");

        }else{ // 登录了 --- 放行
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
