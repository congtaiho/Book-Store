<%-- 
    Document   : inscription
    Created on : Apr 14, 2023, 7:52:19 AM
    Author     : isi
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Entity.Panier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%@include file="header.jsp" %>
        <form action="Inscription" method="POST" style="border:1px solid #ccc">
            <div class="container">
                <h1>Sign Up</h1>
                <%
             String msg = "";
             if(session.getAttribute("message") != null){
               msg = session.getAttribute("message").toString();
               %><h3 style="color: red"><%=msg %></h3>
               <%
               }
        %>
                <p>Merci de remplir ce formulaire pour créer un compte.</p>
                <hr>

                <label for="nom"><b>Nom</b></label>
                <input type="text" placeholder="Entrer Nom" name="nom" required>

                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Entrer Username" name="uname" required>
                
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Entrer Password" name="psw" required>

                <label for="psw-repeat"><b>Repeat Password</b></label>
                <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
                
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Entrer Email" name="email" required> 
                
                <label for="adresse"><b>Adresse</b></label>
                <input  type="text" placeholder="Entrer Adresse" name="adresse"  required>
                
                <label for="tel"><b>Tel</b></label>
                <input  type="text" placeholder="Entrer Tel" name="tel"  required>
                
                <fieldset>
                <label for="dateNaiss"><b>Genre:</b></label>

                <div>
                  <input type="radio" id="femme" name="genre" value="femme"
                         checked>
                  <label for="femme">Femme</label>
                </div>

                <div>
                  <input type="radio" id="dewey" name="genre" value="homme">
                  <label for="homme">Homme</label>
                </div>
                </fieldset>
                <br>
                
                <label for="dateNaiss"><b>Date Naissance</b></label>
                <input  type="text" placeholder="00/00/0000" name="dateNaiss"  required>
                
                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                </label>

                <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Sign Up</button>
                </div>
            </div>
        </form>


        <%@include file="footer.jsp" %>
    </body>
</html>
