<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="autre/import.jsp" %>

    <script>
        function afficherMagasin() {
            document.getElementById("section-magasin").style.display = "block";
            document.getElementById("btn-valider").style.display = "none"; // Cache le bouton après validation
        }

        function afficherPaiement() {
            var magasin = document.getElementById("magasin").value;
            var heure = document.getElementById("heure").value;

            if (magasin && heure) {
                document.getElementById("section-paiement").style.display = "block";
            }
        }

        function afficherBoutonPayer() {
            var numCarte = document.getElementById("numCarte").value;
            var expiration = document.getElementById("expiration").value;
            var cvv = document.getElementById("cvv").value;

            if (numCarte && expiration && cvv) {
                document.getElementById("btn-payer").style.display = "block";
            }
        }
    </script>

</head>
<body>

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

        </div>
    </div>
</header>

<main class="container my-5">
    <h2 class="mb-4">Récapitulatif de votre commande</h2>

    <div class="row">
        <div class="col-md-8">
            <ul class="list-group mb-3">
                <%
                    HashMap<Produit, Integer> panier_user = (HashMap<Produit, Integer>) request.getAttribute("panier_utilisateur");
                    List<Magasin> liste_magasin = (List<Magasin>) request.getAttribute("liste_magasin");

                    for (HashMap.Entry<Produit, Integer> entry : panier_user.entrySet()) {
                        Produit produit_user = entry.getKey();
                        Integer quantity_user = entry.getValue();
                %>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center">
                        <img src="<%= produit_user.getImageURL() %>" alt="<%= produit_user.getLibellePro() %>" class="img-fluid" style="width: 50px; height: auto; margin-right: 15px; border: 1px solid black;">
                        <div>
                            <h6 class="my-0"><%= produit_user.getLibellePro() %> - <%= quantity_user %></h6>
                            <small class="text-muted"><%= produit_user.getDescriptionP() %></small>
                        </div>
                    </div>
                    <span class="text-muted"><%= produit_user.getPrixUnitaire() * quantity_user %>€</span>
                </li>
                <%
                    }
                %>

                <li class="list-group-item d-flex justify-content-between">
                    <span>Total (EUR)</span>
                    <strong>
                        <%
                            double total_user = 0;
                            for (HashMap.Entry<Produit, Integer> entry : panier_user.entrySet()) {
                                total_user += entry.getKey().getPrixUnitaire() * entry.getValue();
                            }
                            total_user = Math.round(total_user * 100.0) / 100.0;
                        %>
                        <%= total_user %>€
                    </strong>
                </li>
            </ul>

            <!-- Bouton pour afficher la section du magasin -->
            <button id="btn-valider" class="btn btn-primary btn-lg w-100" onclick="afficherMagasin()">Valider</button>
        </div>
    </div>

    <!-- Section choix du magasin (cachée par défaut) -->
    <div id="section-magasin" class="row mt-4" style="display: none;">
        <div class="col-md-8">
            <h4>Choisissez un magasin et une heure de retrait</h4>
            <form>
                <div class="mb-3">
                    <label for="magasin" class="form-label">Magasin</label>





                    <select id="magasin" class="form-select" onchange="afficherPaiement()">
                        <option value="">Sélectionnez un magasin</option>

                        <%
                                for (Magasin magasin : liste_magasin) {
                        %>
                        <!-- Génération de chaque option dynamiquement -->
                        <option value="<%= magasin.getIdMag() %>">
                            <%= magasin.getNomMag() + " - " + magasin.getAdresseMag() %>
                        </option>
                        <%
                            }
                        %>
                    </select>





                </div>

                <div class="mb-3">
                    <label for="heure" class="form-label">Heure de retrait</label>
                    <select id="heure" class="form-select" onchange="afficherPaiement()">
                        <option value="">Sélectionnez une heure</option>
                        <option value="08h00">08:00</option>
                        <option value="08h20">08:20</option>
                        <option value="08h40">08:40</option>
                        <option value="09h00">09:00</option>
                        <option value="09h20">09:20</option>
                        <option value="09h40">09:40</option>
                        <option value="10h00">10:00</option>
                        <option value="10h20">10:20</option>
                        <option value="10h40">10:40</option>
                        <option value="11h00">11:00</option>
                        <option value="11h20">11:20</option>
                        <option value="11h40">11:40</option>
                        <option value="12h00">12:00</option>
                        <option value="12h20">12:20</option>
                        <option value="12h40">12:40</option>
                        <option value="13h00">13:00</option>
                        <option value="13h20">13:20</option>
                        <option value="13h40">13:40</option>
                        <option value="14h00">14:00</option>
                        <option value="14h20">14:20</option>
                        <option value="14h40">14:40</option>
                        <option value="15h00">15:00</option>
                        <option value="15h20">15:20</option>
                        <option value="15h40">15:40</option>
                        <option value="16h00">16:00</option>
                        <option value="16h20">16:20</option>
                        <option value="16h40">16:40</option>
                        <option value="17h00">17:00</option>
                        <option value="17h20">17:20</option>
                        <option value="17h40">17:40</option>
                        <option value="18h00">18:00</option>
                        <option value="18h20">18:20</option>
                        <option value="18h40">18:40</option>
                        <option value="19h00">19:00</option>
                        <option value="19h20">19:20</option>
                        <option value="19h40">19:40</option>
                        <option value="20h00">20:00</option>
                        <option value="20h20">20:20</option>
                        <option value="20h40">20:40</option>
                        <option value="21h00">21:00</option>
                    </select>
                </div>
            </form>
        </div>
    </div>

    <!-- Section mode de paiement (cachée par défaut) -->
    <div id="section-paiement" class="row mt-4" style="display: none;">
        <div class="col-md-8">
            <h4>Paiement par carte bancaire</h4>
            <form action="traitement_paiement.jsp" method="post">
                <!-- Numéro de carte -->
                <div class="mb-3">
                    <label for="numCarte" class="form-label">Numéro de carte</label>
                    <input type="text" class="form-control" id="numCarte" name="numCarte" placeholder="1234 5678 9012 3456" required
                           pattern="^\d{4} \d{4} \d{4} \d{4}$" title="Le numéro de carte doit être composé de 16 chiffres séparés par des espaces (ex : 1234 5678 9012 3456)"
                           oninput="afficherBoutonPayer()">
                </div>

                <div class="mb-3 row">
                    <!-- Date d'expiration -->
                    <div class="col-md-6">
                        <label for="expiration" class="form-label">Date d'expiration</label>
                        <input type="text" class="form-control" id="expiration" name="expiration" placeholder="MM/AA" required
                               pattern="^(0[1-9]|1[0-2])\/\d{2}$" title="Le format doit être MM/AA (ex : 12/25)" oninput="afficherBoutonPayer()">
                    </div>

                    <!-- CVV -->
                    <div class="col-md-6">
                        <label for="cvv" class="form-label">CVV</label>
                        <input type="text" class="form-control" id="cvv" name="cvv" placeholder="123" required
                               pattern="^\d{3}$" title="Le CVV doit être composé de 3 chiffres" oninput="afficherBoutonPayer()">
                    </div>
                </div>

                <!-- Bouton de paiement (caché par défaut) -->
                <button id="btn-payer" type="submit" class="btn btn-success btn-lg w-100" style="display: none;">Payer</button>
            </form>
        </div>
    </div>


</main>

<%@ include file="autre/pied_de_page.jsp" %>

</body>
</html>