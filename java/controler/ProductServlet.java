/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Model.Entity.Livre;
import Model.Manager.LivreManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isi
 */
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet{
     LivreManager livreManager;

    @Override
    public void init() throws ServletException {
        livreManager = new LivreManager();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {

         String actionParam = request.getParameter("action");

        ArrayList<Livre> listLivre = null;
       
        System.out.println("STATUS PARAM: " + actionParam);
        System.out.println("DOGET: ");
        if (actionParam == null) {
            System.out.println("Will getAll() and return the list later");
            listLivre = livreManager.getAllLives();
            

        } else {
            System.out.println("[doget] si pas null do some thing");
            listLivre = livreManager.getListLivreByCategorie(actionParam);
        }

        //3 set attribute
        System.out.println("Set attribute");
        request.setAttribute("listLivre", listLivre);

        //4 redirection
        System.out.println("Redirect");
        request.getRequestDispatcher("products.jsp").forward(request, respone);
    }
    
    
}
