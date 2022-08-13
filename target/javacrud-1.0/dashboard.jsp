<%
    if(session.getAttribute("user")==null){
        response.sendRedirect("index.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="assets/partials/css.jsp" %>
        <title>CRUD | DASHBOARD</title>
        
    </head>
    <body>
        <h1>Bonjour <c:out value="${user.username}" /> </h1>
        <a href="signout" >Deconnecter</a>
        <%@include  file="assets/partials/js.jsp" %>
    </body>
</html>
