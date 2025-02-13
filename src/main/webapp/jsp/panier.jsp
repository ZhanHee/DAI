<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="autre/import.jsp" %>

</head>
<body>

<%@ include file="autre/en_tete.jsp" %>

<body>

<!-- Main Content -->
<main class="container my-5">
    <h2 class="mb-4">Votre Panier</h2>

    <div class="row">
        <div class="col-md-8">
            <ul class="list-group mb-3">
                <!-- Boucle dynamique sur les articles du panier -->
                <%
                    HashMap<Produit, Integer> panier_user = (HashMap<Produit, Integer>) request.getAttribute("panier_utilisateur");
                    for (HashMap.Entry<Produit, Integer> entry : panier_user.entrySet()) {
                        Produit produit_user = entry.getKey();
                        Integer quantity_user = entry.getValue();
                %>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center">
                        <!-- Image du produit -->
                        <img src="<%= produit_user.getImageURL() %>" alt="<%= produit_user.getLibellePro() %>" class="img-fluid" style="width: 50px; height: auto; margin-right: 15px; border: 1px solid black;">
                        <div>
                            <h6 class="my-0"><%= produit_user.getLibellePro() %> - <%= quantity_user %></h6>
                            <small class="text-muted"><%= produit_user.getDescriptionP() %></small>
                        </div>
                    </div>
                    <!-- Prix de l'article -->
                    <span class="text-muted"><%= produit_user.getPrixUnitaire() * quantity_user %>€</span>
                </li>
                <%
                    }
                %>

                <!-- Total -->
                <li class="list-group-item d-flex justify-content-between">
                    <span>Total (EUR)</span>
                    <strong>
                        <%
                            double total_user = 0;
                            for (HashMap.Entry<Produit, Integer> entry : panier_user.entrySet()) {
                                total_user += entry.getKey().getPrixUnitaire() * entry.getValue();
                            }
                            total_user = Math.round(total * 100.0) / 100.0;  // Arrondi à 2 décimales
                        %>
                        <%= total_user %>€
                    </strong>
                </li>
            </ul>

            <!-- Checkout Button -->
            <button class="btn btn-primary btn-lg w-100" onclick="window.location.href='checkout.jsp'">Passer à la caisse</button>
        </div>
    </div>
</main>


<%@ include file="autre/pied_de_page.jsp" %>

</body>
</html>
