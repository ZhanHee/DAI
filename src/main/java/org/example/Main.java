package org.example;

import dao.UtilisateurDao;
import metier.Utilisateur;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Utilisateur utilisateur = UtilisateurDao.verifierUtilisateur("zhangzhanhe66@gmail.com", "111");


        System.out.println(utilisateur);
    }
}