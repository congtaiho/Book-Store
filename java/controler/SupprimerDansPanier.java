/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import Model.Entity.Panier;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SupprimerDansPanier", urlPatterns = {"/SupprimerDansPanier"})
public class SupprimerDansPanier extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {    
                 String supId = req.getParameter("id");
                 if (supId != null) {
                     ArrayList<Panier> panier_list = (ArrayList<Panier>) req.getSession().getAttribute("panier-list");
                     if (panier_list != null) {
                        for (Panier p : panier_list) {
                           if (p.getIdLivre() == supId){
                                 panier_list.remove(panier_list.indexOf(p));
                                     break;
                           }
                      }
                }
                  resp.sendRedirect("panier.jsp");

                 } else {
                      resp.sendRedirect("panier.jsp");
                            }

		}
       catch (Exception e) {
            out.println(e);
        }
    }

  

}
