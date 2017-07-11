<%-- 
    Document   : newEducation
    Created on : Jun 21, 2017, 11:29:30 PM
    Author     : aizeeck
--%>

<%@page import="DataObjectsFactories.EducationParser"%>
<%@page import="controllers.EducationController"%>
<%@page import="education.Education"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New education</title>
    </head>
    <body>

        <%if (request.getParameter("educationType") == null || request.getParameter("educationType").equals("")
                    || request.getParameter("institutionName") == null || request.getParameter("institutionName").equals("")
                    || request.getParameter("enrollmentDate") == null || request.getParameter("enrollmentDate").equals("")
                    || request.getParameter("graduationDate") == null || request.getParameter("graduationDate").equals("")) {%>
        <form action="newEducation.jsp">
            <input type="hidden" name="citizenId" value=<%= request.getParameter("citizenId") %>>
            Education type:<br>
            <select name="educationType">
                <option value="primary">Primary</option>
                <option value="secondary">Secondary</option>
                <option value="bachelor">Bachelor</option>
                <option value="master">Master</option>
                <option value="doctorate">Doctorate</option>
            </select>
            <br>
            Institution name:<br>
            <input type="text" name="institutionName" value =
                   <%= request.getParameter("institutionName") == null ? "" : request.getParameter("institutionName")%> >
            <br>
            Enrollment date. Please type the date in format DD.MM.YYYY:<br>
            <input type="text" name="enrollmentDate" value = 
                   <%= request.getParameter("enrollmentDate") == null ? "" : request.getParameter("enrollmentDate")%> >
            <br>
            Graduation date. Please type the date in format DD.MM.YYYY:<br>
            <input type="text" name="graduationDate" value = 
                   <%= request.getParameter("graduationDate") == null ? "" : request.getParameter("graduationDate")%> >
            <br>
            Final grade:<br>
            <input type="text" name="finalGrade" value = 
                   <%= request.getParameter("finalGrade") == null ? "" : request.getParameter("finalGrade")%> >
            <br>

            <br>
            <input type="submit" value="Save">
        </form>     
        <%} else {
            Education education = EducationParser.createEducation(request.getParameterMap());
            int citizenId = Integer.parseInt(request.getParameter("citizenId"));
            if (education != null) {
                EducationController.addEducation(education, citizenId);
            }
        %>
        
        <form action="newEducation.jsp">
            <input type="hidden" name="citizenId" value=<%= request.getParameter("citizenId") %>>
            Education type:<br>
            <select name="educationType">
                <option value="primary">Primary</option>
                <option value="secondary">Secondary</option>
                <option value="bachelor">Bachelor</option>
                <option value="master">Master</option>
                <option value="doctorate">Doctorate</option>
            </select>
            <br>
            Institution name:<br>
            <input type="text" name="institutionName" value="">
            <br>
            Enrollment date. Please type the date in format DD.MM.YYYY:<br>
            <input type="text" name="enrollmentDate" value="">
            <br>
            Graduation date. Please type the date in format DD.MM.YYYY:<br>
            <input type="text" name="graduationDate" value="">
            <br>
            Final grade:<br>
            <input type="text" name="finalGrade" value="">
            <br>
            <br>
            <input type="submit" value="Save">
        </form>    
        <%}%>        
    </body>
</html>
