<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <table class="table caption-top">
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
                    <tr>
                        <td>Identifiant</td>
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>Email</td>
                        <td>Pays</td>
                        <td>
                            <a href="#" class="btn btn-primary">Modifier</a>&nbsp;
                            <a href="#" class="btn btn-danger">Supprimer</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <%@include  file="assets/partials/js.jsp" %>
    </body>
</html>
