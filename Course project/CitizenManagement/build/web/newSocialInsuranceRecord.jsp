<%-- 
    Document   : newSocialInsuranceRecord
    Created on : Jun 21, 2017, 11:29:47 PM
    Author     : aizeeck
--%>

<%@page import="java.util.Arrays"%>
<%@page import="controllers.InsuranceController"%>
<%@page import="insurance.SocialInsuranceRecord"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New insurance record</title>
    </head>
    <body>
        <%if (request.getParameter("insuredMonth") == null || request.getParameter("insuredMonth").equals("")
            || request.getParameter("insurancePayment") == null || request.getParameter("insurancePayment").equals("")) {%>
            <form action="newSocialInsuranceRecord.jsp">
                <input type="hidden" name="citizenId" value =
                       <%= request.getParameter("citizenId") == null ? "" : request.getParameter("citizenId") %> >
                    Insured month. Please type the date in format MM.YYYY:<br>
                <input type="text" name="insuredMonth" value =
                        <%= request.getParameter("insuredMonth") == null ? "" : request.getParameter("insuredMonth") %> >
                <br>
                    Insurance payment amount:<br>
                <input type="text" name="insurancePayment" value = 
                       <%= request.getParameter("insurancePayment") == null ? "" :request.getParameter("insurancePayment") %> >
                <br>
                <br>
                <input type="submit" value="Save">
            </form>    
        <%} else {
            int mapSize = request.getParameterMap().size();
            String tmp = request.getParameter("insuredMonth");
            String mon = tmp.substring(0, tmp.indexOf("."));
            String yr = tmp.substring(tmp.indexOf(".")+1, tmp.length());
            String pmt = request.getParameter("insurancePayment");
            SocialInsuranceRecord insurance = new SocialInsuranceRecord(
                Integer.parseInt(mon), 
                Integer.parseInt(yr), 
                Double.parseDouble(pmt)
            );
            int citizenId = Integer.parseInt(request.getParameter("citizenId"));
            if (insurance != null) {
                InsuranceController.addInsurance(insurance, citizenId);
            }
        %>
        
        <form action="newSocialInsuranceRecord.jsp">
                <input type="hidden" name="citizenId" value=<%= request.getParameter("citizenId") %>>
                    Insured month. Please type the date in format MM.YYYY:<br>
                <input type="text" name="insuredMonth" value="">
                <br>
                    Insurance payment amount:<br>
                <input type="text" name="insurancePayment" value="">
                <br>
                <br>
                <input type="submit" value="Save">
        </form>    
        <%}%>  
    </body>
</html>
