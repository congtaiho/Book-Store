/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import Model.Manager.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "LivreServlet", urlPatterns = {"/Login"})
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try{
        //recuperer les param dans le form login    
        String uname = req.getParameter("uname");
        String psw = req.getParameter("psw");
            //on a fait le code pre
            String query = "SELECT idClient FROM clients WHERE prenom = ? and password = ?";
             PreparedStatement preparedStatement = ConnectionManager.getPs(query);
            preparedStatement.setString(1, uname); // permet de remplacer le premier ?
            preparedStatement.setString(2, psw); // permet de remplacer le deuxième ?
            
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                session.setAttribute("uname",uname);
                 resp.sendRedirect("productServlet");
            }
            else{
                session.setAttribute("msg","UserName ou Mot de passe erroné !");
                resp.sendRedirect("login.jsp");
            }
            ConnectionManager.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
