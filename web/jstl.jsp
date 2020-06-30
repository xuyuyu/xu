<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <table width="70%" border="1px" >
       <tr>
           <td>ID</td>
           <td>USERNAME</td>
           <td>PASSWORD</td>
           <td>SEX</td>
           <td>NAME</td>
           <td>EMAIL</td>
           <td>BIRTHDAY</td>
           <td>遍历时的序号1</td>
           <td>遍历时的序号2</td>

           <c:forEach items="${requestScope.list}" var="u" varStatus="abc" begin="1" end="2">
               <tr>
                   <td>${u.userid}</td>
                   <td>${u.username}</td>
                   <td>${u.password}</td>
                   <td>${u.sex}</td>
                   <td>${u.name}</td>
                   <td>${u.email}</td>
                   <td>${u.birthday}</td>
                   <td>${abc.index}</td>
                   <td>${abc.count}</td>
               </tr>
           </c:forEach>

          <hr/>
          <c:forEach begin="1" end="30" var="x" step="2">${x}</c:forEach>

       </tr>

   </table>
</body>
</html>
