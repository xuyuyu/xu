<%@ page import="com.offcn.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl2</title>
</head>
<body>
   <h1>
       获取User对象中的username值，如果username的值是admin，就在页面上显示，你好管理员
   </h1>

<%--

    <%
        User user = (User)request.getAttribute("u");
        if("admin".equals(user.getUsername())){
    %>
         <h1>你好管理员</h1>
    <%}%>

--%>

<%--
    <c:if test="${requestScope.u.username=='admin'}">
       <h1>你好管理员</h1>
    </c:if>
--%>

     <c:choose>
         <c:when test="${requestScope.u.username=='admin'}">
             <h2>你好管理员</h2>
         </c:when>
         <c:otherwise>
             <h2>你好普通用户</h2>
         </c:otherwise>
     </c:choose>

</body>
</html>
