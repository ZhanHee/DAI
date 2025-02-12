package dao;
import metier.Promotion;

import metier.Produit;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProduitDao {
    //US01
    public static Produit findById(int idPro) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // 只在 Produit 表中查找
            Query<Produit> query = session.createQuery("FROM Produit p WHERE p.idPro = :idPro", Produit.class);
            query.setParameter("idPro", idPro);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //US0.3
    public static List<String> RechercherParMotCle(String motCle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Requête HQL pour rechercher les noms des produits par mot-clé
            String hql = "SELECT p.libellePro FROM Produit p WHERE p.libellePro LIKE :motCle";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("motCle", "%" + motCle + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();  // Retourne une liste vide en cas d'erreur
        }
    }
    public static List<Produit> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // 只在 Produit 表中查找
            Query<Produit> query = session.createQuery("FROM Produit p", Produit.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
