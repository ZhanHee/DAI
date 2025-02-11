package org.example;

import dao.ProduitDao;
import dao.UtilisateurDao;
import metier.Produit;
import metier.Utilisateur;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Utilisateur utilisateur = UtilisateurDao.verifierUtilisateur("zhangzhanhe66@gmail.com", "111");
        Produit  produit = ProduitDao.findById(1);
        List<String> mot= ProduitDao.RechercherParMotCle("b");
        System.out.println(utilisateur);
        System.out.println(produit);
        System.out.println(mot);
    }
}