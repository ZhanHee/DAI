package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategorieDao;
import dao.MagasinDAO;
import dao.ProduitDao;
import metier.Categorie;
import metier.Magasin;
import metier.Produit;

@WebServlet("/achat")
public class achatController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Création de la liste des catégories
        List<Categorie> categories = new ArrayList<>();

        // Ajout de la catégorie Fruits
        Categorie categoriePomme = new Categorie();
        categoriePomme.setIdCtg(1);
        categoriePomme.setNomCtg("Fruits");
        categories.add(categoriePomme);

        // Ajout de la catégorie Légumes
        Categorie categorieLegumes = new Categorie();
        categorieLegumes.setIdCtg(2);
        categorieLegumes.setNomCtg("Légumes");
        categories.add(categorieLegumes);

        // Ajout de la catégorie Produits laitiers
        Categorie categorieLaitiers = new Categorie();
        categorieLaitiers.setIdCtg(3);
        categorieLaitiers.setNomCtg("Produits laitiers");
        categories.add(categorieLaitiers);

        // Ajout de la catégorie Viande
        Categorie categorieViande = new Categorie();
        categorieViande.setIdCtg(4);
        categorieViande.setNomCtg("Viande");
        categories.add(categorieViande);

        // Ajout de la catégorie Boissons
        Categorie categorieBoissons = new Categorie();
        categorieBoissons.setIdCtg(5);
        categorieBoissons.setNomCtg("Boissons");
        categories.add(categorieBoissons);

        // Ajout de la catégorie Boulangerie
        Categorie categorieBoulangerie = new Categorie();
        categorieBoulangerie.setIdCtg(6);
        categorieBoulangerie.setNomCtg("Boulangerie");
        categories.add(categorieBoulangerie);

        HashMap<Produit, Integer> panier = new HashMap<>();

        Produit produit = new Produit(
                categoriePomme,
                "https://www.levergerdescoudreaux.fr/media/images/catalog/article/27/mediumDetail/9.jpg",
                "Verger Delice",
                true, // Correspond à "Bio" qui est à 1
                "6 pièces",
                1, // Poids (1 kg ?)
                "A",
                3.99, // Prix au kg
                2.99, // Prix unitaire
                "Pommes fraîches de variété Granny Smith, croquante...",
                "Pommes Granny Smith",
                1 // ID du produit
        );

        Produit laitEntier = new Produit(
                categoriePomme,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfLiYVbLVGMx8GIoOMiN1RWst2TNNMqYd-NQ&s",
                "Laiterie Montblanc",
                false, // Non bio
                "Brique de 1L",
                1, // Poids (1L)
                "B",
                1.15, // Prix au kg
                1.15, // Prix unitaire
                "Lait entier frais, riche en calcium et vitamine D.",
                "Lait entier 1L",
                2 // ID du produit
        );

        Produit saumon = new Produit(
                categoriePomme,
                "https://www.frais-livre.fr/2369-medium_default/pave-filet-de-saumon-d-ecosse.jpg",
                "Mer&Co",
                false, // Non bio
                "Sous vide",
                0, // Poids inconnu
                "C",
                13.99, // Prix au kg
                8.49, // Prix unitaire
                "Filet de saumon frais, idéal pour une cuisson rapide en poêle ou au four.",
                "Filet de saumon",
                3 // ID du produit
        );

        Produit chipsNature = new Produit(
                categoriePomme,
                "https://m.media-amazon.com/images/I/817dg1j3XEL.jpg",
                "Snacky Crips",
                false, // Non bio
                "Paquet de 200g",
                0, // Poids inconnu
                "C",
                3.98, // Prix au kg
                1.99, // Prix unitaire
                "Chips de pommes de terre naturelles, idéales pour l'apéritif.",
                "Chips nature",
                7 // ID du produit
        );

        Produit yaourtVanille = new Produit(
                categoriePomme,
                "https://media.carrefour.fr/medias/fef14b41871534fa90b9b6b49fa975a7/p_540x540/03279230045014-a1n1-s01",
                "La Laitière",
                false, // Non bio
                "Pot de 150g",
                0, // Poids inconnu
                "B",
                1.35, // Prix au kg
                1.35, // Prix unitaire
                "Yaourt crémeux parfumé à la vanille naturelle, idéal pour le goûter.",
                "Yaourt à la vanille",
                22 // ID du produit
        );

        Produit quinoaBio = new Produit(
                categoriePomme,
                "https://www.leanature.com/media/catalog/product/1/2/1233722-quinoa-graines-gourmandes-sans-gluten-ja",
                "Nature & Cie",
                true, // Bio
                "Paquet de 500g",
                1, // Poids (1kg)
                "A",
                9.98, // Prix au kg
                4.99, // Prix unitaire
                "Quinoa bio, riche en protéines et idéal pour les repas végétariens.",
                "Quinoa bio",
                24 // ID du produit
        );


        Produit produit1 = new Produit(
                categoriePomme,
                "https://www.leanature.com/media/catalog/product/1/2/1233722-quinoa-graines-gourmandes-sans-gluten-ja",
                "Nature & Cie",
                true, // Bio
                "Paquet de 500g",
                1, // Poids
                "A",
                9.98,
                4.99,
                "Quinoa bio, riche en protéines et idéal pour les repas végétariens.",
                "Quinoa bio",
                24
        );

        Produit produit2 = new Produit(
                categoriePomme,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQprZpX9Sds3dUerlrJp8tOytE66zHLNYrmng&s",
                "PizzaFresca",
                false,
                "Pizza de 400g",
                0,
                "B",
                7.98,
                3.99,
                "Pizza surgelée avec tomate, mozzarella et basilic frais.",
                "Pizza Margherita surgelée",
                5
        );

        Produit produit3 = new Produit(
                categoriePomme,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEQLAfOFKZK1Uc4kUgEpqfx5N2tzUTTx5Q8Q&s",
                "Poulet Royal",
                false,
                "Pièce entière",
                0,
                "C",
                12.98,
                7.99,
                "Poulet rôti prêt à consommer, savoureux et doré à point.",
                "Poulet rôti",
                13
        );

        Produit produit4 = new Produit(
                categoriePomme,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRak8dYFa0zD3z1wUYJUanuEn7qvAtb2qMBZg&s",
                "Fruits du Vignoble",
                true,
                "Barquette de 500g",
                1,
                "A",
                9,
                4.5,
                "Raisin rouge frais, sucré et juteux, parfait pour les collations.",
                "Raisin rouge",
                28
        );

        Produit produit5 = new Produit(
                categoriePomme,
                "https://www.andros.fr/wp-content/uploads/2023/04/20220914103320_03045320000481_H1N1-1.png",
                "Fruits du Terroir",
                false,
                "Pot de 200g",
                0,
                "A",
                16.5,
                3.3,
                "Confiture de fraises artisanale, riche en fruits et légèrement sucrée.",
                "Confiture de fraises",
                20
        );

        // Ajout des produits avec des quantités
        panier.put(laitEntier, 2);  // 2 briques de lait entier
        panier.put(saumon, 1);      // 1 filet de saumon
        panier.put(chipsNature, 3); // 3 paquets de chips
        panier.put(yaourtVanille, 4); // 4 yaourts à la vanille
        panier.put(quinoaBio, 1);   // 1 paquet de quinoa bio

        List<Magasin> liste_magasin = MagasinDAO.findAll();

        request.setAttribute("liste_magasin", liste_magasin);
        request.setAttribute("panier_utilisateur", panier);

        request.getRequestDispatcher("/jsp/payer.jsp").forward(request, response);
    }

}
