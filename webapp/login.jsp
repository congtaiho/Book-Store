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
        <div class="container">
        <%
            String msg = "";
            if (session.getAttribute("msg") != null) {
                msg = session.getAttribute("msg").toString();
        %><h3 style="color: red"><%=msg%></h3>
        <%
            }
        %>
        
            <form method="POST" action="Login">
                <div> 
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Entrer Username" name="uname" required>
                </div> 
                <div> 
                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Entrer Password" name="psw" required>
                </div>
                <!-- comment<input type="hidden" name ="msg" value="Login"/> -->
                <button type="submit">Login</button>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>








