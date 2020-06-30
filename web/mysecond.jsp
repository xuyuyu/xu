<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2020/6/11
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp中嵌入java代码</title>
</head>
<body>
    <!-- jsp中嵌入java代码有三种方式-->

    <!-- 第一种  这种方式编写的java代码将会出现在编译后的文件的service方法中-->
    <%
        int x = 10;
        String name="admin";
    %>

    <!-- 第二种  用来输出值到页面上-->
    <%=x%>
    <%=name%>
    <%=1010%>
    <%="张三"%>
    2020
    李四
<hr/>
     <%
        for(int i=1;i<=5;i++){
     %>
          <img src="img/img6.jpg" />
     <%
         }
     %>

     <!--  第三种方式   用来声明成员变量和成员方法。一般不用！-->
     <%!
          String country = "中国";

          public void sayHello(){
              System.out.println("hello.....");
          }
     %>

     <%-- jsp特有的jsp注释方式    通过浏览器查看页面源代码时查看不到jsp的注释 --%>
     <!-- jsp中使用html方式的注释    通过浏览器查看页面源代码时，这个注释可以看到-->

</body>
</html>
