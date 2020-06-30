package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //request.setCharacterEncoding("UTF-8");

           String method = request.getParameter("method");

           if("register".equals(method)){
               register(request,response);
           }else if("login".equals(method)){
               login(request,response);
           }
    }

    // 注册
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2 获取客户端提交的数据 （从请求 request中去获取数据----------->request.getParameter）
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");

        // 3 封装数据到实体类的对象中（传给service层和dao层）
        User user = new User();
        user.setSex(sex);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setBirthday(DateUtil.stringToDate(birthday));

        //4 调用service层 （Service 层调用DAO层）
        UserService service = new UserServiceImpl();
        int result = service.addUser(user);

        if(result>0){
            // System.out.println("添加成功");

            // 重定向
            response.sendRedirect("jsp/login.jsp");

        }else{
            // System.out.println("添加失败");
            response.sendRedirect("jsp/register.jsp");
        }
    }

    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1 获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 调用后台
        UserService service = new UserServiceImpl();
        User user = service.login(username,password);
        if(user!=null){  // 说明用户名密码正确。登录成功！
            // 登录成功，把登录成功的用户的信息保存到session中，再跳转到主页去！
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("jsp/index.jsp");
        }else{ // 用户名或密码错误，登录失败！
            //登录失败，回到登录页面
            response.sendRedirect("jsp/login.jsp?msg=loginerror");
        }
    }


}
