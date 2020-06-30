<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2020/6/16
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>脚本方式取值</h1>
    <%
       String reqValue=(String)request.getAttribute("reqKey");
       /*HttpSession s = request.getSession();
       String sessValue = (String)s.getAttribute("sessKey");*/
       String sessValue = (String)session.getAttribute("sessKey");

    %>
     <h2>
         request:<%=reqValue%>
     </h2>
     <h2>
         session:<%=sessValue%>
     </h2>

     <h1>EL方式取值</h1>

     <h2>request:${requestScope.reqKey}</h2>
     <h2>session:${sessionScope.sessKey}</h2>

<hr/>
       <h1>${requestScope.name}</h1>
       <h1>${sessionScope.name}</h1>
       <h1>${name}</h1> 不指定范围时，会从小到大的去查找（page request session application）
</body>
</html>
