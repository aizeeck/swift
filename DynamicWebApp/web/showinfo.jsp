<%@ page import="personaldetails.Citizen" %>
<%@ page import="controllers.CitizensController" %>
<%--
  Created by IntelliJ IDEA.
  User: aizeeck
  Date: 16.06.17
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%!
   private boolean isNumber(String s) {
       for (char c : s.toCharArray()) {
           if (!Character.isDigit(c)) return false;
       }
       return true;
   }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Info page</title>
    </head>
    <body>
        <%
            String strindCitizenId = request.getParameter("citizenId");
            if (strindCitizenId == null) {
                %>Please privide a valid citizen's id.<%
            } else if (isNumber(strindCitizenId)) {
                Citizen citizen = CitizensController.getCitizenById(Integer.parseInt(strindCitizenId));
                if (citizen != null) {
                    %>Name is <%=citizen.getFirstName()%><%
                } else {
                    %>Please privide a valid citizen's id.<%
                }
            }
        %>
        <p></p>
        <a href="index.jsp">go to start</a>
    </body>
</html>