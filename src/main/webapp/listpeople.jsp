<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.steevelinformaticien.javacrud.dao.PeopleDao" %>
<%@page import="com.steevelinformaticien.javacrud.model.People" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    PeopleDao peopledao=new PeopleDao();
    List<People> data=new ArrayList();
    data=peopledao.getAll();
    request.setAttribute("peopledata",data);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="assets/partials/css.jsp" %>
        <title>CRUD | LIST PEOPLE</title>

    </head>
    <body>
        <%@include  file="assets/partials/header.jsp" %>
        <div class="container mt-4">
            <table id="tb" class="table caption-top">
                <caption>Listes des utilisateurs</caption>
                <thead class="table-dark">
                    <tr>
                        <td>Identifiant</td>
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>Email</td>
                        <td>Pays</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${peopledata}" var="value">
                    <tr>
                        <td><c:out value="${value.id}" /></td>
                        <td><c:out value="${value.nom}" /></td>
                        <td><c:out value="${value.prenom}" /></td>
                        <td><c:out value="${value.email}" /></td>
                        <td><c:out value="${value.pays}" /></td>
                        <td>
                            <a href="<c:out value="http://localhost:8080/javacrud/editpeople.jsp?id=${value.id}" />" class="btn btn-primary">Modifier</a>&nbsp;
                            <a href="<c:out value="${value.id}" />" class="btn btn-danger del">Supprimer</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <%@include  file="assets/partials/js.jsp" %>
        <script src="assets/js/people.js"></script>
    </body>
</html>
