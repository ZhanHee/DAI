package dao;

import metier.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class utilisateurDao {

    public Utilisateur findByEmail(String email){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Utilisateur> query = session.createQuery("FROM Utilisateur WHERE emailUser = :email", Utilisateur.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Utilisateur verifierUtilisateur(String email, String password) {
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

    public boolean isAdmin(String email){
        return false;
    }
}
