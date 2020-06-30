package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/ELTestServlet")
public class ELTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("companyname","中公教育");
        request.setAttribute("now",new Date());

        User user = new User();
        user.setUserid(101);
        user.setBirthday(DateUtil.stringToDate("1999-10-10"));
        user.setUsername("admin");
        user.setEmail("admin@aaa.com");
        user.setName("小毛");
        user.setPassword("234234");
        user.setSex("男");
        request.setAttribute("u",user);


        int[] aa = {1,2,3,4,5};
        request.setAttribute("aa",aa);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);

        Map<String,String> map = new HashMap<>();
        map.put("cat","猫");
        map.put("dog","狗");
        map.put("pig","猪");
        request.setAttribute("map",map);


        request.getRequestDispatcher("el.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doPost(request, response);
    }
}
