<%-- 
    Document   : wishlist
    Created on : Nov 10, 2016, 8:06:35 PM
    Author     : Sweet_Home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist Page</title>
    </head>
    <body  style="background-color: #e3e8f8">
        <%@ include file="header.jsp" %>>
        <%@ include file="headerClose.jsp" %>
    <h1 align="center">Your Wishlist</h1>
    <table style="width:100%; border:1px solid black;">
  <tr>
    <th style="border:1px solid black;">Book Title</th>
    <th style="border:1px solid black;">Book Author</th> 
    <th style="border:1px solid black;">Options</th> 
  </tr>
    
                        <c:forEach items="${books}" var="item">
                            <tr style="border:1px solid black;">
                                <td style="border:1px solid black;">${item.title}</td>
                                    <td style="border:1px solid black;">${item.author}</td> 
                                    <td style="border:1px solid black;">
                                        <form name="deleteWishlist" action="WishlistServlet" method="post" align="center">
                                            <input type="hidden" name="action" value="deleteWishlist">
                                            <input type="hidden" name="username" value="${user.getUserName()}"></input>
                                            <input type="hidden" name="bookid" value=${item.bookID}>
                                            <input type="hidden" name="books" value="${books}">
                                            <input type="submit" value="Remove from wishlist" />
                                        </form>
                                        <form name="viewBook" action="BookListServlet" method="post" align="center">
                                            <input type="hidden" name="action" value="viewBook">
                                            <input type="hidden" name="bookid" value=${item.bookID}>
                                            <input type="submit" value="View Details" />
                                        </form>
                                    </td>
                            </tr>           
                                      
                        </c:forEach>   
    </table> 
    
    <form name="viewhome" action="WishlistServlet" method="post">
        <input type="hidden" name="username" value="${user.getUserName()}"</input>
        <input type="hidden" name="action" value="backHome">
        <input type="submit" value="Back to homepage" 
               style="background-color: #4CAF50; 
                        border: none;
                        color: white;
                        padding: 15px 32px;
                        text-align: center;
                        text-decoration: none;
                        display: inline-block;
                        font-size: 16px;
                        margin: 4px 2px;
                        cursor: pointer;"/>
    </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
