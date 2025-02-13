package dao;

import metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MagasinDAO {

    // Trouver un magasin par son ID
    public static Magasin findById(int idMag) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Magasin> query = session.createQuery("FROM Magasin m WHERE m.idMag = :idMag", Magasin.class);
            query.setParameter("idMag", idMag);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Rechercher des magasins par nom (mot-clé)
    public static List<String> rechercherParMotCle(String motCle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m.nomMag FROM Magasin m WHERE m.nomMag LIKE :motCle";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("motCle", "%" + motCle + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Récupérer tous les magasins
    public static List<Magasin> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Magasin> query = session.createQuery("FROM Magasin m", Magasin.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Ajouter un magasin
    public static boolean addMagasin(Magasin magasin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(magasin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    // Mettre à jour un magasin
    public static boolean updateMagasin(Magasin magasin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(magasin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    // Supprimer un magasin
    public static boolean deleteMagasin(int idMag) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Magasin magasin = session.get(Magasin.class, idMag);
            if (magasin != null) {
                session.delete(magasin);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}