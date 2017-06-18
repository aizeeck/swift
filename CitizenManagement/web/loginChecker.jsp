<%@ page import="users.UsersManager" %><%--
  Created by IntelliJ IDEA.
  User: aizeeck
  Date: 18.06.17
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login check</title>
</head>
<body>
<%
    if (UsersManager.checkCredentials(request.getParameter("user"), request.getParameter("pass"))) {
        %> <a href="underConstruction.jsp"></a> <%
    } else {
        %> <a href="error.jsp"></a> <%
    }
%>
</body>
</html>
