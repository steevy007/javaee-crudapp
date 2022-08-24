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
        <title>CRUD | ADD PEOPLE</title>

    </head>
    <body>
        <%@include  file="assets/partials/header.jsp" %>

        <div class="container mt-4">
            <form>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nom</label>
                    <input type="text" class="form-control" id="nom" name="nom" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Prenom</label>
                    <input type="text" id="prenom" class="form-control" name="prenom"  class="form-control" >
                </div>
                <div class="mb-3 ">
                    <label class="form-label" for="exampleCheck1">Email</label>
                    <input type="email" class="form-control" id="email">
                    
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Pays</label>
                    <input type="text" id="pays" class="form-control" name="pays"  class="form-control" >
                </div>
                <input type="submit" class="btn btn-primary" value="Enregistrer" />
            </form>
        </div>

        <%@include  file="assets/partials/js.jsp" %>
    </body>
</html>
