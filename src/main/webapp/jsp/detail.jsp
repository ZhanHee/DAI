<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%
    Produit produit = (Produit) request.getAttribute("produit"); // Récupération de l'objet produit
    if (produit == null) {
        response.sendRedirect("index.jsp"); // Redirection si le produit est inexistant
        return;
    }
    
%>


<!DOCTYPE html>
<html lang="en">

	<%@ include file="autre/import.jsp" %>
	
  <body>



	<%@ include file="autre/en_tete.jsp" %>


    <title><%= produit.getLibellePro() %> - FoodMart</title>
	<section class="py-5">
	<div class="container mt-5">
	    <div class="row">
	        <!-- Image du produit -->
	        <div class="col-md-6">
	            <figure>
	                <img src="<%= produit.getImageURL() %>" class="img-fluid" alt="<%= produit.getLibellePro() %>" style="border: 1px solid black; margin-left:10px; width:300px; height:300px;">
	            </figure>
	        </div>
	
	        <!-- Détails du produit -->
	        <div class="col-md-6">
	            <h2><%= produit.getLibellePro() %></h2>
	            <span class="category text-muted">Catégorie : <strong><%= produit.getCategorie() != null ? produit.getCategorie().getNomCtg() : "Inconnue" %></strong></span>
	
	            <!-- Prix et réduction -->
	            <div class="price-section my-3">
	                <span class="new-price text-success fw-bold"><%= produit.getPrixUnitaire()%> €</span> <!-- Exemple de réduction à 30% -->
	            </div>
	
	            <!-- Description -->
	            <p class="product-description">
	                <%= produit.getDescriptionP() %>
	            </p>
	
	            <!-- Stock disponible -->
	            <p class="<%= produit.getPoids() > 0 ? "text-success" : "text-danger" %>">
	                <strong><%= produit.getPoids() > 0 ? "En stock" : "Rupture de stock" %></strong>
	            </p>
	
	            <!-- Sélection de la quantité -->
	            <form action="ajouterAuPanier" method="post">
	                <input type="hidden" name="idProduit" value="<%= produit.getIdPro() %>">
	                <div class="d-flex align-items-center">
	                    <div class="input-group product-qty me-3">
	
	                        <input type="number" id="quantite" name="quantite" min="1" max="<%= produit.getPoids() %>" value="1" class="input-number" style="width: 30% !important; text-align: center;">
	
	                    </div>
	                    <button type="submit" class="btn btn-primary" <%= produit.getPoids() > 0 ? "" : "disabled" %> style="width: 200% !important; text-align: center;">
	                        Ajouter au panier <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-cart"><path d="M16 16a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm5-13h-2.5L16.5 0h-9L5.5 3H3a1 1 0 0 0 0 2h1l.6 3h12.8l.6-3h1a1 1 0 1 0 0-2ZM6.25 3l1-2h7.5l1 2H6.25ZM5 7l-1.2 6h14.4L19 7H5ZM2 20a2 2 0 1 1 4 0 2 2 0 0 1-4 0Zm14 0a2 2 0 1 1 4 0 2 2 0 0 1-4 0Z"/></svg>
	                    </button>
	                </div>
	            </form>
	        </div>
	    </div>
	</div>
	
	</section>







	<%@ include file="autre/pied_de_page.jsp" %>

    

    
  </body>
</html>