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

        List<Produit> produits = ProduitDao.findAll();

        System.out.println(produits);


    }
}