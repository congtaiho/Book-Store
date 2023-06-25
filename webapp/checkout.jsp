<%-- 
    Document   : checkout
    Created on : Apr 20, 2023, 10:19:32 PM
    Author     : isi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%
            if (session.getAttribute("uname") != null) {%>
        <%@include file="headerConnect.jsp" %>
        <% } else {%>
        <%@include file="header.jsp" %>
        <%}
        %>

        <div class="container my-3">
            <div class="d-flex py-3"><h3>Summary:</h3> <a class="mx-3 btn btn-primary" href="">Check Out</a></div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Panier panier : panier_list) {%>
                    <tr>
                        <td><%=panier.getTitleProd() %></td>
                        <td><%= %></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <a href="SupprimerDansPanier?id=" class="btn btn-sm btn-danger">Supprimer</a>
        </div>

        <!--payment-->

        <div class="container my-3">
            <h1>Checkout</h1>
            <h4>Payment Details</h4>
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="cardName">Card Holder Name</label>
                        <input type="text" class="form-control" id="cardName" placeholder="Susie Que">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cardNum">Card Number</label>
                        <input type="password" class="form-control" id="cardNum" placeholder="1234567890098765">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="endDate">Expiration Date: Month</label>
                        <select id="endDate" class="form-control">
                            <option selected>01</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="endDate">Year</label>
                        <select id="endDate" class="form-control">
                            <option selected>2018</option>
                            <option>2019</option>
                            <option>2020</option>
                            <option>2021</option>
                            <option>2022</option>
                        </select>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="cVV">CVV</label>
                        <input type="text" class="form-control" id="cVV" placeholder="123">
                    </div>
                </div>

                <button class="btn btn-primary">submit</button>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
