package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SessionTest4Servlet")
public class SessionTest4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           /*
            *    session对象的销毁：
            *                     1、关闭服务器
            *                     2、session的生命周期到期   默认是30分钟。可以修改！
            *                        在web.xml
            *                          <session-config>
                                              <session-timeout>整数的分钟</session-timeout>
            *                          </session-config>
            *                          默认的30分钟或者是设置的session过期时间是指，这个时间内，不对浏览器进行任何操作
            *
            *                     3、调用session的invalidate方法
            *
            * 关闭浏览器时，服务器端的session对象不会被销毁，只是保存session的id的cookie不存在了。
            * 就不能再拿到服务器中原有的session对象了。
            *
            * */

        HttpSession sess = request.getSession();
        System.out.println(sess.getId());

        sess.invalidate();

        HttpSession sess2 = request.getSession();
        System.out.println(sess2.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request, response);
    }
}
