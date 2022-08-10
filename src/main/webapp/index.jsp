

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/index.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />
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
                    <input type="email"id="l_email" name="l_email" placeholder="Enter email or username"/>
                    <input type="password" id="l_password" name="l_password" placeholder="Enter password"/>
                    <button type="submit" class="btn login">login</button>
                    <p><a href="javascript:void(0)">Forgotten account</a></p>
                    <hr/>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-google-plus-g fa-lg"></i> sign in with google</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-linkedin fa-lg"></i> sign in with linkedin</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-microsoft fa-lg"></i> sign in with microsoft</button>
                </form>
            </div>

            <div id="signup-form">
                <form method="POST" class="signup-form" action="user" >
                    <input type="email" id="email" name="email" placeholder="Enter your email"/>
                    <input type="text" id="username" name="username" placeholder="Choose username"/>
                    <input type="number" id="phone" name="phone" placeholder="50944111987" />
                    <input type="password" id="password" name="password" placeholder="Create password"/>
                    <button type="submit" class="btn signup">create account</button>
                    <p>Clicking <strong>create account</strong> means that you are agree to our <a href="javascript:void(0)">terms of services</a>.</p>
                    <hr/>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-google-plus-g fa-lg"></i> sign in with google</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-linkedin fa-lg"></i> sign in with linkedin</button>
                    <button type="button" class="btn -box-sd-effect"> <i class="fa-brands fa-microsoft fa-lg"></i> sign in with microsoft</button>
                </form>
            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>

        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="assets/js/main.js"></script>
        <script src="assets/js/index.js"></script>
    </body>
</html>
