<%-- 
    Document   : female_outcome
    Created on : 16 May 2024, 8:04:15 PM
    Author     : sifis
--%>

<%@page import="za.ac.tut.models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        
       Employee count = (Employee)request.getAttribute("count");
       
        %>
    <body>
        <%=count.getName()%>
      
    </body>
</html>
