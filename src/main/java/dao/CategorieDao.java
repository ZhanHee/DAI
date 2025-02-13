package dao;

import metier.Categorie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CategorieDao {

    // Trouver une catégorie par son ID
    public static Categorie findById(int idCtg) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Requête HQL pour trouver une catégorie par ID
            Query<Categorie> query = session.createQuery("FROM Categorie c WHERE c.idCtg = :idCtg", Categorie.class);
            query.setParameter("idCtg", idCtg);
            return query.uniqueResult(); // Retourne un seul résultat
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Rechercher des catégories par nom (mot clé)
    public static List<String> RechercherParMotCle(String motCle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Requête HQL pour rechercher les noms des catégories par mot-clé
            String hql = "SELECT c.nomCtg FROM Categorie c WHERE c.nomCtg LIKE :motCle";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("motCle", "%" + motCle + "%");
            return query.list(); // Retourne la liste des noms de catégories
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();  // Retourne une liste vide en cas d'erreur
        }
    }

    // Récupérer toutes les catégories
    public static List<Categorie> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Requête HQL pour récupérer toutes les catégories
            Query<Categorie> query = session.createQuery("FROM Categorie c", Categorie.class);
            return query.getResultList(); // Retourne la liste des catégories
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
