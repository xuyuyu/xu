<%@ page import="java.util.Date" %>
<%@ page import="com.offcn.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2020/6/12
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>
    <%--
      <%
          String companyname= (String)request.getAttribute("companyname");
          Date d = (Date)request.getAttribute("now");
          User user = (User)request.getAttribute("u");
      %>

      <h1>展示companyname</h1>
      <%=companyname%>
      <hr/>

      <h1>展示日期</h1>
      <%=d%>
      <hr/>
      <h1>展示user信息</h1>
      <%=user.getUserid()%>--
      <%=user.getUsername()%>--
      <%=user.getPassword()%>--
      <%=user.getSex()%>--
      <%=user.getBirthday()%>--
      <%=user.getEmail()%>--
      <%=user.getName()%>--
      --%>
     <%
        String name = (String)request.getAttribute("name");
     %>
     <%=name%>
    >>>>${requestScope.name}<<<<

     <h1>使用el方式获取数据</h1>
     <h2>展示companyname</h2>
     ${requestScope.companyname}------- ${companyname} 如果不指定作用域就会按照 page、request、session、application的顺序去查找
     <div>如果每个作用域都找不到就返回空串</div>
    <hr/>
    <h2>展示日期</h2>
     ${requestScope.now}
     <hr/>
     <h2>user信息(User对象中的属性，必须有对应的get方法)</h2>
    ${requestScope.u.userid}--
    ${requestScope.u.username}--
    ${requestScope.u.password}--
    ${requestScope.u.name}--
    ${requestScope.u.sex}--
    ${requestScope.u.birthday}--
    ${requestScope.u.email}
<hr/>
<h1>el表达式不能遍历集合，只能取集合中的某个值或某些特征</h1>
<h2>获取数组</h2>
数组的第2个值 ${requestScope.aa[1]}
<h2>获取list</h2>
list的第3个元素${requestScope.list[2]}
<h2>获取map</h2>
map可以完成根据key取value${requestScope.map["dog"]}

<h1>el表达式做运算（包括数学运算和逻辑运算）</h1>
${5+3}--${5-3}--${5*3}--${5/3}
<hr/>
${5>3}--${5<3}--${requestScope.u.name=='小毛'}

<hr/>
<h1>el表达式提供了11个对象可以使用(掌握几个常用的就可以)</h1>

${pageContext.request.method}---${pageContext.request.contextPath}

</body>
</html>
