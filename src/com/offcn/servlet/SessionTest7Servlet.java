package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SessionTest7Servlet")
public class SessionTest7Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("SessionTest7Servlet```");

        request.setAttribute("reqKey","reqValue");
        HttpSession session = request.getSession();
        session.setAttribute("sessKey","sessValue...");

        request.setAttribute("name","优就业");
        request.setAttribute("name","中公教育");  // 后存的会覆盖前面的
        session.setAttribute("name","大数据");

        request.getRequestDispatcher("session.jsp").forward(request,response);
       // response.sendRedirect("session.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }
}
