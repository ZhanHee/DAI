<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>

	<%@ include file="autre/import.jsp" %>

  </head>
  <body>

	<%@ include file="autre/en_tete.jsp" %>


<section class="py-5">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="bootstrap-tabs product-tabs">
          <div class="tabs-header d-flex justify-content-between border-bottom my-5">
            <h3>Nos produits</h3>
            
          </div>
          <div class="tab-content" id="nav-tabContent">

              <div class="tab-pane fade show active" id="nav-all" role="tabpanel" aria-labelledby="nav-all-tab">
                  <div class="product-grid row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 g-4">
                      <!-- Début de la boucle pour afficher les produits -->
                      <%
                          List<Produit> liste_produit = (List<Produit>) request.getAttribute("liste_produit");
                          String recherche = (String) request.getAttribute("recherche");

                          if (recherche == null || recherche.equals("aucune")) {
                              recherche = "";
                          } else {
                              recherche = recherche.toLowerCase();
                          }

                          String categorie_chercher = (String) request.getAttribute("categorie");
                          int categorie_chercher_int = 0;

                          if (categorie_chercher == null || categorie_chercher.equals("aucune")) {
                              categorie_chercher_int = 0;
                          }
                          else
                          {
                              categorie_chercher_int = Integer.parseInt(categorie_chercher);
                          }


                          for (Produit le_produit : liste_produit) {
                              if (le_produit.getLibellePro().toLowerCase().contains(recherche)) {
                                  if (categorie_chercher_int == le_produit.getCategorie().getIdCtg()|| categorie_chercher_int == 0) {
                      %>
                      <div class="col">
                          <div class="product-item card shadow-sm h-100">
                              <!-- Image du produit -->
                              <figure class="position-relative">
                                  <a href="produit?produit=<%= le_produit.getIdPro() %>" title="<%= le_produit.getLibellePro() %>">
                                      <img src="<%= le_produit.getImageURL() %>" class="card-img-top product-image" alt="<%= le_produit.getLibellePro() %>">
                                  </a>
                              </figure>

                              <div class="card-body d-flex flex-column">
                                  <!-- Nom du produit -->
                                  <h5 class="card-title text-center"><%= le_produit.getLibellePro() %></h5>

                                  <!-- Prix du produit -->
                                  <p class="price text-center fw-bold text-primary"><%= le_produit.getPrixUnitaire() %>€</p>

                                  <!-- Quantité et bouton d'ajout au panier -->
                                  <div class="mt-auto">
                                      <div class="d-flex align-items-center justify-content-between">
                                          <input type="number" produit="quantity" name="quantity" class="form-control input-number w-25 text-center" value="1" min="1">
                                          <a href="#" class="btn btn-primary d-flex align-items-center gap-2">
                                              <iconify-icon icon="uil:shopping-cart"></iconify-icon>
                                              Ajouter au panier
                                          </a>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <%
                              }
                          }
                          }
                      %>
                      <!-- Fin de la boucle -->
                  </div>
                  <!-- / product-grid -->
              </div>



          </div>
        </div>
      </div>
    </div>
  </div>
</section>



	<%@ include file="autre/pied_de_page.jsp" %>

    
  </body>
</html>