/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session = req.getSession();
        try{
        String nom = req.getParameter("nom");
        String uname = req.getParameter("uname");
        String psw = req.getParameter("psw");
        String pswRepeat = req.getParameter("psw-repeat");
        String email = req.getParameter("email");
        String adresse = req.getParameter("adresse");
        String tel = req.getParameter("tel");
        String genre = req.getParameter("genre");
        String dateNaiss = req.getParameter("dateNaiss");
        
        RequestDispatcher dispatcher = null;
            
        Class.forName("org.mariadb.jdbc.Driver");  //charger le diver MariaDB
        String urlServeur="jdbc:mariadb://localhost:3310/bdEBoutiqueLivres";
        //localhost est l'URL de connexion, ca pourrait aussi être une adresse ip
        //3310 est le port du serveur mariaDB
        //maBd le nom de la base de donnée que l'on veut accéder.
        String identifiant = "root";
        String motDePasse = "abc123...";
            Connection connection = DriverManager.getConnection(urlServeur, identifiant, motDePasse);
            
            //on a fait le code pre
            String query = "INSERT INTO clients (nom, prenom, password, email, adresse, tel, genre, dateNaissance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nom); 
            preparedStatement.setString(2, uname); 
            preparedStatement.setString(3, psw); 
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, adresse);
            preparedStatement.setString(6, tel);
            preparedStatement.setString(7, genre);
            preparedStatement.setString(8, dateNaiss);
            
            int nombreLigne = preparedStatement.executeUpdate();
            dispatcher = req.getRequestDispatcher("inscription.jsp");
            if(psw.equals(pswRepeat)){
                 if(nombreLigne > 0){
                //req.setAttribute("message", "Success");
                session.setAttribute("uname",uname);
                resp.sendRedirect("login.jsp");
               }
            }
            else{
                session.setAttribute("message", "Echoué");
                resp.sendRedirect("inscription.jsp");
            }
           dispatcher.forward(req, resp);
            connection.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }

}
