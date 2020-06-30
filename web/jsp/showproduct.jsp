<%@ page import="java.util.List" %>
<%@ page import="com.offcn.bean.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <%
         List<Product> list = (List<Product>)request.getAttribute("allProductList"); // 从request作用域取出list
     %>

     <table border="1px" width="50%">
         <tr>
             <td>ID</td>
             <td>NAME</td>
             <td>IMG</td>
         </tr>

         <%
            for(Product p:list){
         %>
          <tr>
              <td>
                  <%=p.getPro_id()%>
              </td>
              <td>
                  <%=p.getPro_name()%>
              </td>
              <td>
                  <img src="<%=p.getPro_min_img()%>" />
              </td>
          </tr>

         <%}%>

     </table>
</body>
</html>
