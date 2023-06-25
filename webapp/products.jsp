<%-- 
    Document   : products
    Created on : Apr 14, 2023, 7:48:23 AM
    Author     : isi
--%>

<%@page import="Model.Entity.Panier"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//data
    ArrayList<Livre> listLivres = (ArrayList<Livre>) request.getAttribute("listLivre");


%>
<% ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");

List<Panier> cartProduct = null;
if (panier_list != null) {
	request.setAttribute("panier_list", panier_list);
}
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%            if (session.getAttribute("uname") != null) {%>
        <%@include file="headerConnect.jsp" %>
        <% } else {%>
        <%@include file="header.jsp" %>
        <%}
        %>

        <!-- Section-->
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <%for (Livre list : listLivres) {%>
                    <div class="col mb-5">
                        <div class="card h-100">


                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>

                            <!-- Product image-->
                            <img class="card-img-top" <img src="img/<%=list.getImageLivre()%>" alt="<%=list.getTitleProd()%>"/>

                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=list.getTitleProd()%></h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted"><%=list.getPrix()%>0$</span>

                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="AddToPanierServlet?id=<%= list.getIdLivre()%>&nom=<%= list.getTitleProd()%>&catg=<%= list.getIdCatg()%>&prix=<%= list.getPrix()%>">Add to cart</a></div>
                            </div>

                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </section>


        <%@include file="footer.jsp" %>
    </body>
</html>
