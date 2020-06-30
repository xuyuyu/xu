<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2020/6/11
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
  <!-- 浏览器直接访问index.jsp时，index.jsp需要发送请求到servlet去查询数据-->
  <%
       //response.sendRedirect("../ProductServlet?method=findAllProduct");
       //response.sendRedirect("../Product2Servlet?method=findAllProduct");
      response.sendRedirect("../Product3Servlet?method=findAllProduct");
  %>
</body>
</html>
