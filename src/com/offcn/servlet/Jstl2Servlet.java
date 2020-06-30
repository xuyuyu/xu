package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.offcn.bean.User;
import com.offcn.utils.DateUtil;

@WebServlet("/Jstl2Servlet")
public class Jstl2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = new User();
            user.setUserid(1);
            user.setBirthday(DateUtil.stringToDate("1999-10-10"));
            user.setUsername("admin");
            user.setEmail("admin@aaa.com");
            user.setName("小毛");
            user.setPassword("234234");
            user.setSex("男");
            request.setAttribute("u",user);
            request.getRequestDispatcher("jstl2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request, response);
    }
}
