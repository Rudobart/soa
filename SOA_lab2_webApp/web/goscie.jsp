<%--
  Created by IntelliJ IDEA.
  User: bartlomiej
  Date: 17.03.19
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Komentarze</h1>
<form action="post" method="post">
    Komentarz: <input type="text" name="comment"/>
    <input type="submit"/>
</form>
<c:forEach items="${posts}" var="item">
    <h3>${item.Gosc.login}</h3>
    <h5>${item.Gosc.email}</h5>
    ${item.comment}<br>
</c:forEach>

</body>
</html>
