<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.util.HashMap" %>

<div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasCart" aria-labelledby="My Cart">
  <div class="offcanvas-header justify-content-center">
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
    <div class="order-md-last">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-primary">Votre panier</span>
        <span class="badge bg-primary rounded-pill">
          <%
            HashMap<Produit, Integer> panier = (HashMap<Produit, Integer>) request.getAttribute("panier_utilisateur");
            int totalArticles = 0;
            if (panier != null) {
                for (HashMap.Entry<Produit, Integer> entry : panier.entrySet()) {
                    totalArticles += entry.getValue();
                }
            }
          %>
          <%= totalArticles %>
        </span>
      </h4>
      <ul class="list-group mb-3">
        <%
          double total = 0;
          for (HashMap.Entry<Produit, Integer> entry : panier.entrySet()) {
            Produit produit_panier = entry.getKey();
            Integer quantity = entry.getValue();
            total += produit_panier.getPrixUnitaire() * quantity;
        %>
        <li class="list-group-item d-flex justify-content-between lh-sm">
          <div>
            <h6 class="my-0"><%= produit_panier.getLibellePro() %> - <%= quantity %></h6>
            <small class="text-body-secondary"><%= produit_panier.getDescriptionP() %></small>
          </div>
          <span class="text-body-secondary"><%= produit_panier.getPrixUnitaire() * quantity %>€</span>
        </li>
        <%
          }
          total = Math.round(total * 100.0) / 100.0;
        %>
        <li class="list-group-item d-flex justify-content-between">
          <span>Total (EUR)</span>
          <strong><%= total %>€</strong>
        </li>
      </ul>
      <a href="produit?produit=panier">
        <button class="w-100 btn btn-primary btn-lg">Passer commande</button>
      </a>
    </div>
  </div>
</div>

<header>
  <div class="container-fluid">
    <div class="row py-3 border-bottom align-items-center">

      <!-- Logo à gauche -->
      <div class="col-sm-4 col-lg-3 text-center text-sm-start">
        <div class="main-logo">
          <a href="produit?produit=all">
            <img src="images/logo.png" alt="logo" class="img-fluid">
          </a>
        </div>
      </div>

      <!-- Barre de recherche au centre -->
      <div class="col-sm-6 col-lg-6">
        <form id="search-form" class="d-flex align-items-center bg-light p-2 rounded-4" action="produit" method="get">
          <input type="hidden" name="produit" value="all" />

          <%
            // Récupérer la catégorie pré-sélectionnée
            String categorie_preselect = (String) request.getAttribute("categorie");
            int categorie_chercher_preselect_int = 0;

            if (categorie_preselect != null && !categorie_preselect.equals("aucune")) {
              try {
                categorie_chercher_preselect_int = Integer.parseInt(categorie_preselect);
              } catch (NumberFormatException e) {
                categorie_chercher_preselect_int = 0; // Valeur par défaut si conversion échoue
              }
            }

            // Récupérer la liste des catégories
            List<Categorie> listeCategories = (List<Categorie>) request.getAttribute("liste_categorie");
          %>

          <!-- Sélection de la catégorie -->
          <select name="categorie" class="form-select border-0 bg-transparent me-2" style="max-width: 150px;">
            <option value="0" <%= (categorie_chercher_preselect_int == 0) ? "selected" : "" %>>Tout</option>
            <%
              if (listeCategories != null) {
                for (Categorie categorie : listeCategories) {
                  int categorieId = categorie.getIdCtg();
            %>
            <option value="<%= categorieId %>" <%= (categorie_chercher_preselect_int == categorieId) ? "selected" : "" %>>
              <%= categorie.getNomCtg() %>
            </option>
            <%
                }
              }
            %>
          </select>


          <!-- Champ de recherche -->
          <%
            String recherche_value = (String) request.getAttribute("recherche");
            if (recherche_value == null || recherche_value.equals("aucune")) {
              recherche_value = ""; // Si aucune recherche, laisser vide
            }
          %>

          <div class="input-group">
            <input type="text" class="form-control border-0 shadow-sm rounded-pill px-3"
                   name="recherche"
                   placeholder="Chercher un produit..."
                   value="<%= recherche_value %>">
          </div>



          <!-- Bouton Rechercher -->
          <button type="submit" class="btn btn-primary">Rechercher</button>
        </form>
      </div>

      <!-- Liens et panier à droite -->
      <div class="col-sm-2 col-lg-3 d-flex justify-content-end gap-3 align-items-center">
        <a href="#" class="rounded-circle bg-light p-2">
          <svg width="24" height="24" viewBox="0 0 24 24"><use xlink:href="#user"></use></svg>
        </a>
        <button class="border-0 bg-transparent d-flex flex-column gap-2 lh-1" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasCart">
          <span class="fs-6 text-muted">Votre panier</span>
          <span class="cart-total fs-5 fw-bold"><%= total %>€</span>
        </button>
      </div>

    </div>
  </div>
</header>
