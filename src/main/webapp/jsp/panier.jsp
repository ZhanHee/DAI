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
                        List<Map<String, Object>> listeProduit = (List<Map<String, Object>>) request.getAttribute("listeProduit");
                        Panier panier = (Panier) request.getAttribute("panier");

                        if (listeProduit != null && !listeProduit.isEmpty()) {
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

                            <!-- 修改数量 -->
                            <div class="input-group product-qty">
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-left-minus btn btn-danger btn-number" data-type="minus" onclick="changeQuantity(this.closest('.product-item'), -1)">
                                        <svg width="16" height="16"><use xlink:href="#minus"></use></svg>
                                    </button>
                                </span>
                                <input type="text" class="form-control input-number product-quantity" value="<%= quantite %>" readonly>
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" onclick="changeQuantity(this.closest('.product-item'), 1)">
                                        <svg width="16" height="16"><use xlink:href="#plus"></use></svg>
                                    </button>
                                </span>
                            </div>

                            <!-- 商品数量和单价 -->
                            <span class="text-muted">
                                <%= quantite %> x $<%= produit.getPrixUnitaire() %>
                            </span>

                            <!-- 单件商品总价 -->
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

                <div class="row">
                    <div class="col-6">
                        <!-- Clear panier Button -->
                        <form action="clearPanier" method="get">
                            <button type="submit" class="btn btn-primary btn-lg w-100">Clear Panier</button>
                        </form>
                    </div>
                    <div class="col-6">
                        <!-- Checkout Button -->
                        <form action="commande" method="post">
                            <button type="submit" class="btn btn-primary btn-lg w-100">Confirmez la commande</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="text-center py-3">
        <p class="text-muted"> @ 2025 FoodMart - Tous droits reserves.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
