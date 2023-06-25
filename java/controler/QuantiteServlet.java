/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Entity.Panier;

/**
 *
 * @author isi
 */
@WebServlet(name = "QuantiteServlet", urlPatterns = {"/QuantiteServlet"})
public class QuantiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			String action = req.getParameter("action");
			String id = req.getParameter("id");
                            ArrayList<Panier> panier_list = (ArrayList<Panier>) req.getSession().getAttribute("panier-list");

			if (action != null) {
				if (action.equals("inc")) {
					for (Panier p : panier_list) {
						if (p.getIdLivre().equals(id)) {
							int quantity = p.getQuantite();
							quantity++;
							p.setQuantite(quantity);
							resp.sendRedirect("panier.jsp");
						}
					}
				}

				if (action.equals("dec")) {
					for (Panier p : panier_list) {
						if (p.getIdLivre().equals(id) && p.getQuantite() > 1) {
							int quantity = p.getQuantite();
							quantity--;
							p.setQuantite(quantity);
							break;
						}
					}
					resp.sendRedirect("panier.jsp");
				}
			} else {
				resp.sendRedirect("panier.jsp");
			}
		}
    }

  
}
