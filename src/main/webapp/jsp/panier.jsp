<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="metier.Produit" %>
<%@ page import="metier.Panier" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Votre Panier - FoodMart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/vendor.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <!-- Header -->
    <header>
        <div class="container-fluid">
            <div class="row py-3 border-bottom">
                <div class="col-sm-4 col-lg-3 text-center text-sm-start">
                    <div class="main-logo">
                        <a href="index.html">
                            <img src="images/logo.png" alt="logo" class="img-fluid">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <main class="container my-5">
        <h2 class="mb-4">Votre Panier</h2>

        <div class="row">
            <div class="col-md-8">
                <ul class="list-group mb-3">

                    <!-- Liste de produits -->
                    <%
                        // 获取产品和数量列表
                        List<Map<String, Object>> listeProduit = (List<Map<String, Object>>) request.getAttribute("listeProduit");
                        Panier panier = (Panier) request.getAttribute("panier");

                        if (listeProduit != null && !listeProduit.isEmpty()) {
                            // 遍历购物车中的所有商品
                            for (Map<String, Object> produitInfo : listeProduit) {
                                Produit produit = (Produit) produitInfo.get("produit");
                                int quantite = (int) produitInfo.get("quantite"); // 获取数量
                    %>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <div class="d-flex align-items-center">
                                <!-- 商品图片 -->
                                <img src="<%= produit.getImageURL() %>" alt="<%= produit.getLibellePro() %>" class="img-fluid" style="width: 50px; height: auto; margin-right: 15px; border: 1px solid black;">
                                <div>
                                    <h6 class="my-0"><%= produit.getLibellePro() %></h6>
                                    <small class="text-muted"><%= produit.getDescriptionP() %></small>
                                </div>
                            </div>

                            <!-- 商品数量和单价 -->
                            <span class="text-muted">
                                <%= quantite %> x $<%= produit.getPrixUnitaire() %>
                            </span>

                            <!-- 总价 -->
                            <strong>$<%= quantite * produit.getPrixUnitaire() %></strong>
                        </li>
                    <%
                            }
                        } else {
                    %>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            Votre panier est vide.
                        </li>
                    <%
                        }
                    %>

                    <!-- Total -->
                    <li class="list-group-item d-flex justify-content-between">
                        <strong>Total (USD)</strong>
                        <strong>$<%= panier != null ? panier.getPrixTotal() : 0 %></strong>
                    </li>
                </ul>

                <!-- Checkout Button -->
                <form action="panier" method="post">
                    <button type="submit" class="btn btn-primary btn-lg w-100">Confirmez la commande</button>
                </form>
        </div>
    </main>

    <!-- Footer -->
    <footer class="text-center py-3">
        <p class="text-muted"> @ 2025 FoodMart - Tous droits reserves.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
