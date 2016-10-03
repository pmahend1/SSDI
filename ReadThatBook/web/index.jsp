<%-- 
    Document   : home
    Created on : 1 Oct, 2016, 9:10:12 PM
    Author     : Prateek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    </head>
    <body>
        <h3>Read that Book</h3>
        <p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
        <form name="login" action="LoginServlet" method="post">
            <input type="hidden" name="action" value="login">   
            <label >User Name</label>
            <input name="userName" type="text"/><br></br>
            <label>Password</label>
            <input name="passWord" type="password" /><br></br>
            <input type="submit" value="Login"/>
        </form>
        <form name="register" action="LoginServlet" method="post">
            <input type="submit" name="register" value="Register"/>
            <input type="hidden" name="action" value="register"/>
        </form>
    </body>
</html>

