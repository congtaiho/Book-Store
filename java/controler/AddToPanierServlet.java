/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import Model.Entity.Panier;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "AddToPanierServlet", urlPatterns = {"/AddToPanierServlet"})
public class AddToPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         PrintWriter out = resp.getWriter();
        try {
            ArrayList<Panier> panierList = new ArrayList<>();
            String id = req.getParameter("id");
            
            String nom = req.getParameter("nom");
            String catg = req.getParameter("catg");
            double prix = Double.parseDouble(req.getParameter("prix"));
            
            Panier panier = new Panier();
            panier.setIdLivre(id);
            
            panier.setTitleProd(nom);
            panier.setIdCatg(catg);
            panier.setPrix(prix);
            
            panier.setQuantite(1);
            
            HttpSession session = req.getSession();
            ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");
            if (panier_list == null) {
                panierList.add(panier);
                session.setAttribute("panier-list", panierList);
                //out.println("Ajout et Session bien créer");
                resp.sendRedirect("productServlet");
            } else {
                //out.println("exist déjà");
                panierList = panier_list;
                boolean exist = false;
                for (Panier pan : panier_list) {
                    if (pan.getIdLivre().equals(id)) {
                        exist = true;
                       // out.println("<h3 style='color:crimson; text-align: center'>Article déjà dans le panier. <a href='panier.jsp'>Aller à la page Panier </a></h3>");
                        resp.sendRedirect("panier.jsp");
                    }

                    if (!exist) {
                    panierList.add(panier);
                   // out.println("Livre ajouté");
                    resp.sendRedirect("productServlet");
                    }       
                }
            }
            
        } catch (Exception e) {
            out.println(e);
        }
    }
    
}
