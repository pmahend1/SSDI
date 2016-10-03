<%-- 
    Document   : register
    Created on : 2 Oct, 2016, 7:55:25 PM
    Author     : Prateek
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h3>Register</h3>
        <form name="registerForm" action="LoginServlet" method="post">
            <label >User Name</label>
            <input type="text" name="userName"/>
            <span style = "color:red" ng-show = "registerForm.userName.$dirty && registerForm.firstname.$invalid">
                        <span ng-show = "registerForm.firstname.$error.required">User Name is required.</span>
                     </span>
            <br/>
            <label> Password </label>
            <input type="password" name="passWord"/><br/>
            <label> Re enter Password </label>
            <input type="password" name="rePassword"/><br/>
            <label> First Name </label>
            <input type="text" name="firstName"/><br/>
            <label> Last Name </label>
            <input type="text" name="lastName"/><br/>
            <label> Email </label>
            <input type="email" name="email"/><br/>
            <input type="hidden" name="action" value="registerForm" />
            <input type="submit"/>
        </form>
    </body>
</html>
