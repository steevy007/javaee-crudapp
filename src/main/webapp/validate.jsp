<%-- 
    Document   : forgetpwd
    Created on : Aug 12, 2022, 9:54:10 PM
    Author     : PEPECELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="assets/partials/css.jsp" %>
        <title>CRUD | Validate Password</title>
    </head>
    <body>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <div class="form-gap"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <h3><i class="fa fa-lock fa-4x"></i></h3>
                                <h2 class="text-center">Validate Password</h2>
                                <p>Enter OTP to validate</p>
                                <div class="panel-body">

                                    <form id="forget-form"class="validate-form" role="form" autocomplete="off" action="validatepswd"  method="post">

                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                <input id="validate" name="validate" placeholder="123456" class="form-control"  type="number">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input  type="submit" name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Validate OTP" type="submit">
                                        </div>

                                        <input type="hidden" class="hide" name="token" id="token" value=""> 
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include  file="assets/partials/js.jsp" %>
        <script src="assets/js/validateotp.js"></script>
    </body>
</html>
