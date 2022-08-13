<%
    if(session.getAttribute("user")!=null){
        response.sendRedirect("dashboard.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="assets/partials/css.jsp" %>
        <title>CRUD | INDEX</title>
    </head>
    <body>
        <div class="form-modal">

            <div class="form-toggle">
                <button id="login-toggle" onclick="toggleLogin()">log in</button>
                <button id="signup-toggle" onclick="toggleSignup()">sign up</button>
            </div>

            <div id="login-form">
                <form method="POST" class="login-form">
                    <input type="email"id="l_email" name="l_email" placeholder="Enter email or username" required/>
                    <input type="password" id="l_password" name="l_password" placeholder="Enter password" required/>
                    <button type="submit" class="btn login">login</button>
                    <p><a href="forgetpwd.jsp">Forgotten account</a></p>
                    <hr/>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-google-plus-g fa-lg"></i> sign in with google</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-linkedin fa-lg"></i> sign in with linkedin</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-microsoft fa-lg"></i> sign in with microsoft</button>
                </form>
            </div>

            <div id="signup-form">
                <form method="POST" class="signup-form" action="user" >
                    <input type="email" id="email" name="email" placeholder="Enter your email" required/>
                    <input type="text" id="username" name="username" placeholder="Choose username" required/>
                    <input type="number" id="phone" name="phone" placeholder="50944111987" required/>
                    <input type="password" id="password" name="password" placeholder="Create password"required/>
                    <button type="submit" class="btn signup">create account</button>
                    <p>Clicking <strong>create account</strong> means that you are agree to our <a href="javascript:void(0)">terms of services</a>.</p>
                    <hr/>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-google-plus-g fa-lg"></i> sign in with google</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-linkedin fa-lg"></i> sign in with linkedin</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-microsoft fa-lg"></i> sign in with microsoft</button>
                </form>
            </div>

        </div>
        <%@include  file="assets/partials/js.jsp" %>
        <script src="assets/js/main.js"></script>
        <script src="assets/js/index.js"></script>
    </body>
</html>
