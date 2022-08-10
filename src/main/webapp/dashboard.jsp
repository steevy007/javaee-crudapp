<%-- 
    Document   : dashboard.jsp
    Created on : Aug 9, 2022, 11:28:06 PM
    Author     : PEPECELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bonjour <c:out value="${user.username}" /> </h1>
    </body>
</html>
