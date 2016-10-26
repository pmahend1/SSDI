/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import business.Book;
import data.BookDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Prateek
 */
public class BookManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = "/index.jsp";
        String message = "";
        System.out.println("admin.BookManager.doPost()" + action);
        if (action == null) {
            action = "viewHome";
        } else if (action.equals("addBook")) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String ISBN_13 = request.getParameter("ISBN_13");
            String ISBN_10 = request.getParameter("ISBN_10");
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            String edition = request.getParameter("edition");
            String publisher = request.getParameter("publisher");
            System.out.println("admin.BookManager.doPost()" + title);
            System.out.println("admin.BookManager.doPost()" + description);
            System.out.println("admin.BookManager.doPost()" + ISBN_13);
            System.out.println("admin.BookManager.doPost()" + ISBN_10);
            System.out.println("admin.BookManager.doPost()" + author);
            System.out.println("admin.BookManager.doPost()" + genre);
            System.out.println("admin.BookManager.doPost()" + edition);
            System.out.println("admin.BookManager.doPost()" + publisher);

            Book newBook = new Book(title, author, ISBN_10, ISBN_13, genre, edition, publisher, description);
            BookDB.addBook(newBook);
            url="/index.jsp";
            request.setAttribute("newBook", newBook);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
