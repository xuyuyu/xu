package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value="/SessionTest5Servlet",name="Sess5Servlet")
public class SessionTest5Servlet extends HttpServlet {
    /*HttpSession作为作用域*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          HttpSession session = request.getSession();
          request.setAttribute("requestKey","requestValue......");
          session.setAttribute("sessionKey","sessionValue######");

          //request.getRequestDispatcher("SessionTest6Servlet").forward(request,response);
          response.sendRedirect("SessionTest6Servlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doPost(request, response);
    }
}
