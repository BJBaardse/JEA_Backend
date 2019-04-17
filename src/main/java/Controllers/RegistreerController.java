package Controllers;

import model.User;
import model.UserDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name="loginServlet", displayName="loginServlet", urlPatterns = {"/register"}, loadOnStartup=1)
public class RegistreerController extends HttpServlet {
//
//    @EJB
//    UserDao userDao;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        long personid = Integer.parseInt(req.getParameter("username"));
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//        int age = Integer.parseInt(req.getParameter("age"));
//        this.userDao.save(new User(username, password, email, age, role));
//
//        try {
//            req.setAttribute("loggedinuser", "Pieter");
//
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//    }
}