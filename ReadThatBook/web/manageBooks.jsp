<%-- 
    Document   : manageBooks
    Created on : 23 Oct, 2016, 9:06:10 PM
    Author     : Prateek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="scripts/angular.min.js"></script>
        <script src="scripts/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
        <script src="js/manageBooks.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">

        <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        </style>
        <title>Manage Books</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <!--#e3e8f8-->
	<%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;"><c:out value="${cookie['userCookie'].value}" ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
	<br/>
    <h4>Add book from Google Books</h4>
    <form action="GoogleBooksApiServlet" method="POST">
        <input type="text" placeholder="Title or Author" name="query" style="width: 450px"/>
        <input type="submit" class="btn btn-primary btn-sm" name="Search" value="Search"/>
        <p style="color:red;"><c:if test="${not empty messageText}"><c:out value="${messageText}"/></c:if></p>
    </form>
        <div id="results"></div>
        <br>
        <div><a class="btn btn-primary" href="BookManager?action=addBookPage">Add Books Manually</a></div>
        <br>
        <h3 align="center">Book Details </h3>
        <br>
        <div>
        <table class="table table-striped">
            <thead class="thead-default">
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Edition</th>
                    <th>Genre</th>
                    <th>ISBN10</th>
                    <th>ISBN13</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td><c:out value="${book.getTitle()}"/></td>
                        <td><c:out value="${book.getAuthor()}"/></td>
                        <td><c:out value="${book.getEdition()}"/></td>
                        <td><c:out value="${book.getGenre()}"/></td>
                        <td><c:out value="${book.getISBN10()}"/></td>
                        <td><c:out value="${book.getISBN13()}"/></td>
                        <td><center><a href="<c:url value="BookManager?action=updateBookPage&bookID=${book.getBookID()}"/>" class ="btn btn-primary btn-xs">Edit</a></center></td>
                        <td><a href="<c:url value="BookManager?action=deleteBook&bookID=${book.getBookID()}"/>" class ="btn btn-primary btn-xs">Delete</a></td>
                    </tr>
                </c:forEach>          
        </table>       
        </div>
        <br>
    </body>
    <%@ include file="footer.jsp" %>
</html>
