/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.User;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Prateek
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = "/index.jsp";
        String message = "";
        System.out.println("admin.LoginServlet.doPost()" + action);

        if (action == null) {
            action = "viewHome";
        } else if (action.equals("login")) {
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            User user = UserDB.selectUser(userName);
            System.out.println("admin.LoginServlet.doPost()" + "userName " + userName);
            System.out.println("admin.LoginServlet.doPost()" + "passWord " + passWord);
            if (userName == null) {
                userName = "dummy";
            }
            if (passWord == null) {
                passWord = "dummy";
            }
            if (user == null) {
                System.out.println("admin.LoginServlet.doPost()" + "User Does not exist");
            } else if (passWord.equals(user.getPassWord())) {
                //user is registered
                url = "/home.jsp";
                request.setAttribute("user", user);
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            } else {
                message = "Incorrect username or password";
                url = "/index.jsp";
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            }

        } else if (action.equals("register")) {
            url = "/register.jsp";
            System.out.println("admin.LoginServlet.doPost()" + action + " else if");
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("registerForm")) {
            System.out.println("admin.LoginServlet.doPost()" + action + " else if");
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String rePassWord = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            System.out.println("admin.LoginServlet.doPost()" + userName);

            System.out.println("admin.LoginServlet.doPost()" + passWord);
            System.out.println("admin.LoginServlet.doPost()" + rePassWord);
            System.out.println("admin.LoginServlet.doPost()" + firstName);
            System.out.println("admin.LoginServlet.doPost()" + lastName);
            System.out.println("admin.LoginServlet.doPost()" + email);

            if (userName.isEmpty() || passWord.isEmpty() || rePassWord.isEmpty()
                    || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                userName = "dummy";
                lastName = "dummy";
                rePassWord = "dummy1";
                email = "dummy";
                firstName = "dummy";
                lastName = "dummy";
            } else if (passWord.equals(rePassWord)) {
                User newUser = new User(userName, firstName, lastName, email, passWord, "user");
                UserDB.insert(newUser);
                url = "/home.jsp";
                User user = UserDB.selectUser(userName);
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }

        }

    }

}
