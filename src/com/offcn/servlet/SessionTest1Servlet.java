package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SessionTest1Servlet")
public class SessionTest1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取HttpSession的对象，如果是第一次获取，服务器负责创建
        HttpSession s = request.getSession();
        System.out.println("SessionTest1Servlet: "+s.getId()+"<<<>>>");

        HttpSession s2 = request.getSession();
        System.out.println("SessionTest1Servlet: "+s2.getId()+">>><<<");

        System.out.println(s==s2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doPost(request,response);
    }
}
