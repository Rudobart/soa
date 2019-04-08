<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: bartlomiej
  Date: 11.03.19
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Lab SOA - pierwszy serwlet</title>
  </head>
  <body>
    <h1>to jest moja pierwsza apka w JavaEE</h1>
    <p>wywyw</p>
    <%
      Date tmp = new Date();
      out.print("<h2>" +tmp.toString() + "</h2>");
    %>
  </body>
</html>
