<%@page  import="com.steevelinformaticien.javacrud.model.People" %>
<%@page  import="com.steevelinformaticien.javacrud.dao.PeopleDao" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    } else {
        try {
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                //create daopeople
                PeopleDao peopledao = new PeopleDao();
                People people = (People) peopledao.getPeopleById(id);
                if (people != null) {
                    request.setAttribute("people", people);
                }
            }
        } catch (Exception e) {

        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="assets/partials/css.jsp" %>
        <title>CRUD | EDIT PEOPLE</title>
    </head>
    <body>
        <%@include  file="assets/partials/header.jsp" %>
        <div class="container mt-4">
            <form id="form-editpeople" class="form-editpeople">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nom</label>
                    <input type="text" class="form-control" value="<c:out value="${people.nom}"/>" id="nom" name="nom" aria-describedby="emailHelp" required>
                    <input type="hidden" class="form-control" value="<c:out value="${people.id}"/>" id="id" name="id" aria-describedby="emailHelp" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Prenom</label>
                    <input type="text" id="prenom" class="form-control" value="<c:out value="${people.prenom}"/>" name="prenom"  class="form-control"  required>
                </div>
                <div class="mb-3 ">
                    <label class="form-label" for="exampleCheck1">Email</label>
                    <input type="email" class="form-control" value="<c:out value="${people.email}"/>" name="email" id="email" required>
                    <input type="hidden" class="form-control" value="<c:out value="${people.email}"/>" name="oldemail" id="oldemail" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Pays</label>
                    <input type="text" id="pays" class="form-control" value="<c:out value="${people.pays}"/>" name="pays"  class="form-control" required>
                </div>
                <input type="submit" class="btn btn-primary" value="Modifier" />
            </form>
        </div>
        <%@include  file="assets/partials/js.jsp" %>
        <script src="assets/js/people.js"></script>
    </body>
</html>
