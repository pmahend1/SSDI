<%-- 
    Document   : addBooks
    Created on : 24 Oct, 2016, 7:30:06 PM
    Author     : Prateek
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Book</title>
    </head>
    <body>
        <h1>Add A Book Manually</h1>
        <form action="BookManager" method="POST">
            <input type="hidden" name="action" value="addBook"/>
            <table>
                <tbody>
                    <tr>
                        <td>Book Title</td>
                        <td>:</td>
                        <td><input type="text" name="title"/></td>
                    </tr>
                    <tr>
                        <td>ISBN-13</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_13"></td>
                    </tr>
                    <tr>
                        <td>ISBN-10</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_10"></td>
                    </tr>
                    <tr>
                        <td>Author</td>
                        <td>:</td>
                        <td><input type="text" name="author"/></td>
                    </tr>
                    <tr>
                        <td>Genre</td>
                        <td>:</td>
                        <td><input type="text" name="genre"/></td>
                    </tr>
                    <tr>
                        <td>Edition</td>
                        <td>:</td>
                        <td><input type="text" name="edition"/></td>
                    </tr>
                    <tr>
                        <td>Publisher</td>
                        <td>:</td>
                        <td><input type="text" name="publisher"/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>:</td>
                        <td><textarea rows="4" cols="21" name="description"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" /></td>
                        <td>  </td>
                        <td><input type="reset" /></td>
                    </tr>
                </tbody>
            </table>

            
        </form>
    </body>
</html>

