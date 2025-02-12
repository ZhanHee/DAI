package dao;

import metier.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class UtilisateurDao {


    public static Utilisateur findByEmail(String email){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Utilisateur> query = session.createQuery("FROM Utilisateur WHERE emailUser = :email", Utilisateur.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Utilisateur verifierUtilisateur(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Utilisateur> query = session.createQuery("FROM Utilisateur WHERE emailUser = :email AND motPasse = :password", Utilisateur.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return query.uniqueResult(); // 返回匹配的用户
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean creerUtilisateur(Utilisateur user) {
        if (findByEmail(user.getEmailUser()) != null) {
            return false;
        }

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAdmin(String email){
        return false;
    }
}
