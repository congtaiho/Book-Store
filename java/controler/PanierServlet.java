/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Model.Entity.Livre;
import Model.Manager.LivreManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet("/panier")
public class PanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 param
        String idParam = request.getParameter("id");
        ArrayList<Livre> listLivreById = null;
        Livre livre;
        //2 traitement
        if (idParam != null) {
            HttpSession session = request.getSession();
            HashMap<String, Integer> panier = (HashMap<String, Integer>) session.getAttribute("panier");
            if (panier == null) {
                panier = new HashMap<>();
                session.setAttribute("panier", panier);
            }
            if (panier.containsKey(idParam)) {
                panier.replace(idParam, (panier.get(idParam) + 1));
            } else {
                panier.put(idParam, 1);
            }
        }

       
        //4 redirection
        response.sendRedirect("productServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listLivres", LivreManager.getAllLives());
        HttpSession session = request.getSession();
        //1 param
        String designation = request.getParameter("idLivre");
        String action = request.getParameter("action");
        //2 traitement
        //recuperer le hashMap de la session
        HashMap<String, Integer> panier = (HashMap<String, Integer>) session.getAttribute("panier");
        //Si le panier n'exite pas, on va creer panier
        if (panier == null) {
            panier = new HashMap<>();
            session.setAttribute("panier", panier);

        }
        if ("+".equals(action)) {

            if (panier.containsKey(designation)) {
                panier.replace(designation, (panier.get(designation) + 1));
            } else {
                panier.put(designation, 1);
            }
        } else if ("-".equals(action)) {
            if (panier.containsKey(designation)) {
                if (panier.get(designation) - 1 < 0) {
                    //cas ou soustraction est negative
                    panier.remove(designation);
                } else {
                    //cas ou je peux enlever une quantite
                    panier.replace(designation, (panier.get(designation) - 1));
                }
            }
        }
        //3 redirection ver panier.jsp
        request.getRequestDispatcher("panier.jsp").forward(request, response);

    }

}
