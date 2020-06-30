<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2020/6/12
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>java脚本方式取值</h1>
   <%
      String name = request.getParameter("name");
   %>
   <%=name%>

   <h1>el表达式方式取值</h1>
   ${param.name}
</body>
</html>
