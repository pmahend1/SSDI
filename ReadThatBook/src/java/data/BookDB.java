package data;

import java.sql.*;

import business.Book;

public class BookDB {

    public static int addBook(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("data.BookDB.addBook()");
        String query
                    = "INSERT INTO Book ( Title , Author, ISBN10, ISBN13, Genre ,Edition, Publisher ,Description ) "
                + "VALUES (?, ?, ? , ?, ?, ? ,? ,?)";
        try {
            ps = connection.prepareStatement(query);
           
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getISBN_10());
            ps.setString(4, book.getISBN_13());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getEdition());
            ps.setString(7, book.getPublisher());
            ps.setString(8, book.getDescription());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    
    public static Book selectBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Book "
                + "WHERE BookName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            rs = ps.executeQuery();
            Book book = null;
            if (rs.next()) {
                book = new Book();
                ps.setInt(1, book.getBookID());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthor());
                ps.setString(4, book.getISBN_10());
                ps.setString(5, book.getISBN_13());
                ps.setString(6, book.getGenre());
                ps.setString(7, book.getEdition());
                ps.setString(8, book.getPublisher());
                ps.setString(9, book.getDescription());
            }
            return book;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int deleteBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("data.BookDB.deleteBook()");
        String query
                    = "DELETE from Book where "
                + "bookID = ?";
        try {
            ps = connection.prepareStatement(query);
           
            ps.setInt(1, bookID);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
}
