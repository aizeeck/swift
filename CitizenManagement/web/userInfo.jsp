<%@page import="insurance.SocialInsuranceRecord"%>
<%@page import="education.GradedEducation"%>
<%@page import="education.Education"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="controllers.EducationController"%>
<%@page import="controllers.CitizensController"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="personaldetails.Citizen" %>
<%@ page import="personaldetails.Gender" %>
<%--
  Created by IntelliJ IDEA.
  User: aizeeck
  Date: 18.06.17
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>

<style>
div.scroll {
    position: absolute;
    top:  150px;
    left: 600px;
    width: 180px;
    height: 200px;
    overflow: scroll;
}
</style>

<%!
    Citizen citizen = null;
%>

<%!
    private boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User info</title>
    </head>
    <body>
        <form action="userInfo.jsp">
            <input type="text" name="citizenId">
            <input type="submit" value="find">
        </form>

        <%
            String strindCitizenId = request.getParameter("citizenId");
            if (strindCitizenId == null) {
        %>Please privide a valid citizen's id.<%
        } else if (isNumber(strindCitizenId)) {
            citizen = CitizensController.getCitizenById(Integer.parseInt(strindCitizenId));

        %>
        <br>
        Main information of citizen <%= request.getParameter("citizenId") %>:
        <table border="1">
            <tbody>
                <tr>
                    <td>First name</td>
                    <td><%= citizen.getFirstName()%></td> 
                </tr>
                <tr>
                    <td>Mid name</td>
                    <td><%= citizen.getMiddleName()%></td> 
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><%= citizen.getLastName()%></td> 
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td><%= citizen.getDateOfBirth()%></td> 
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><%= citizen.getGender().equals(Gender.Male) ? "Мъж" : "Жена"%></td> 
                </tr>
            </tbody>
        </table>
        <br>
        Address:
        <table border="1">
            <tbody>
                <tr>
                    <td>Country</td>
                    <td><%= citizen.getAddress().getCountry()%></td> 
                </tr>
                <tr>
                    <td>City</td>
                    <td><%= citizen.getAddress().getCity()%></td> 
                </tr>
                <tr>
                    <td>Municipality</td>
                    <td><%= citizen.getAddress().getMunicipality()%></td> 
                </tr>
                <tr>
                    <td>Postal code</td>
                    <td><%= citizen.getAddress().getPostalCode()%></td> 
                </tr>
                <tr>
                    <td>Address</td>
                    <td><%= citizen.getAddress().getStreet() + ", " + citizen.getAddress().getNumber()%></td> 
                </tr>
            </tbody>
        </table>
        <br>
        Educations:
        <table border="1">
            <tbody>
                <tr>
                    <td>
                        Degree
                    </td>
                    <td>
                        Institution name
                    </td>
                    <td>
                        Enrollment date
                    </td>
                    <td>
                        Graduation date
                    </td>
                    <td>
                        Final grade
                    </td>
                </tr>
                <%
                List<Education> educations = citizen.getEducations();
                for (Education education : educations) {%>
                    <tr>
                        <td>
                            <%= education.getDegree()%>
                        </td>
                        <td>
                            <%= education.getInstitutionName()%>
                        </td>
                        <td>
                            <%= education.getEnrollmentDate()%>
                        </td>
                        <td>
                            <%= education.getGraduationDate()%>
                        </td>

                        <%if (education instanceof GradedEducation) {
                            GradedEducation educationEval = (GradedEducation) education;
                            %>
                            <td>
                                <%= educationEval.isGraduated() ? educationEval.getFinalGrade() : "N/A"  %>
                            </td>
                        <%} else {%>
                                <td>
                                N/A
                                </td>
                        <%}%>
                    </tr>
                <%}%>

            </tbody>
        </table>
        <br>
            <a href="newEducation.jsp?citizenId=<%= request.getParameter("citizenId")%>" >Add education</a>
        <br>
        <br>
            <a href="newSocialInsuranceRecord.jsp?citizenId=<%= request.getParameter("citizenId")%>" >Add social insurance record</a>
        <br>
        <br>
        <%}%>
        <form>
            <input type="hidden" name="haveIBeenHere" value ="false">
            <%
                if (!Boolean.parseBoolean(request.getParameter("haveIBeenHere"))) {%>
                    <a href="userInfo.jsp?citizenId=<%= request.getParameter("citizenId")%>&haveIBeenHere=<%= true %>" >Check for social payments </a>
                <%} else { %>
                    <%boolean isPaymentRelevant = CitizensController.isPaymentRelevant(citizen);%>
                    <%if(isPaymentRelevant) { %>
                    <%= String.format("value is %.2f", CitizensController.calculateSocialPayment(citizen.getSocialInsuranceRecords())) %>
                    <div class="scroll">
                            <table border="1">
                                <tbody>
                                    <tr>
                                        <td>
                                            Year
                                        </td>
                                        <td>
                                            Month
                                        </td>
                                        <td>
                                            Amount
                                        </td>
                                    </tr>
                                <%
                                List<SocialInsuranceRecord> insurances = citizen.getSocialInsuranceRecords();
                                for (SocialInsuranceRecord insurance : insurances) {%>
                                    <tr>
                                        <td>
                                            <%= insurance.getYear()%>
                                        </td>
                                        <td>
                                            <%= insurance.getMonth()%>
                                        </td>
                                        <td>
                                            <%= insurance.getAmount()  %>
                                        </td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    <%} else {
                        %>
                        Citizen is not social payment relevant.
                        <div class="scroll">
                            <table border="1">
                                <tbody>
                                    <tr>
                                        <td>
                                            Year
                                        </td>
                                        <td>
                                            Month
                                        </td>
                                        <td>
                                            Amount
                                        </td>
                                    </tr>
                                <%
                                List<SocialInsuranceRecord> insurances = citizen.getSocialInsuranceRecords();
                                for (SocialInsuranceRecord insurance : insurances) {%>
                                    <tr>
                                        <td>
                                            <%= insurance.getYear()%>
                                        </td>
                                        <td>
                                            <%= insurance.getMonth()%>
                                        </td>
                                        <td>
                                            <%= insurance.getAmount()  %>
                                        </td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    <%}%>
                <%}%>
        </form>
    </body>
</html>