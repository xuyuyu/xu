package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserid(101);
        user.setBirthday(DateUtil.stringToDate("1999-10-10"));
        user.setUsername("admin");
        user.setEmail("admin@aaa.com");
        user.setName("小毛");
        user.setPassword("234234");
        user.setSex("男");

        User user2 = new User();
        user2.setUserid(102);
        user2.setBirthday(DateUtil.stringToDate("1999-10-10"));
        user2.setUsername("zhangsan");
        user2.setEmail("zhangsan@aaa.com");
        user2.setName("张三");
        user2.setPassword("123123");
        user2.setSex("男");

        User user3 = new User();
        user3.setUserid(102);
        user3.setBirthday(DateUtil.stringToDate("1999-10-10"));
        user3.setUsername("lisi");
        user3.setEmail("lisi@aaa.com");
        user3.setName("李四");
        user3.setPassword("123123");
        user3.setSex("男");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);

        request.setAttribute("list",list);
        request.getRequestDispatcher("jstl.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }
}
