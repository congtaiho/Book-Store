/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

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
 * @author isi
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class logout extends HttpServlet {

      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession session = req.getSession();
          //session.removeAttribute("uname");
          //resp.sendRedirect("login.jsp");
          session.invalidate();

          /* Redirection vers le Site du Zéro ! */
          resp.sendRedirect("productServlet");
          
      }
}
