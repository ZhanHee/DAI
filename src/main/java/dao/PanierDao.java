package dao;

import metier.Client;
import metier.Composer;
import metier.Panier;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import static dao.ProduitDao.findById;

public class PanierDao {

    // 获取当前用户id的购物车
    public static Panier getPanierByIdClient(int idUser){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Panier> query = session.createQuery("FROM Panier WHERE idUser = :id", Panier.class);
            query.setParameter("id", idUser);
            Panier panier = query.uniqueResult();
            session.close();
            return panier;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //添加商品到购物车
    public static void addProduitToPanier(int idUser, int idPro, int quantite){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction ts = session.beginTransaction();

            Panier panier = getPanierByIdClient(idUser);
            if(panier == null){
                panier = new Panier();
                panier.setStatut("En cours");
                panier.setPrixTotal(0);
                panier.setClient(session.get(Client.class, idUser));
                session.save(panier);
            }

            Produit produit = session.get(Produit.class, idPro);

            Composer composer = new Composer();
            composer.setProduit(produit);
            composer.setPanier(panier);
            composer.setQuantiteP(quantite);

            session.save(composer);

            panier.setPrixTotal(panier.getPrixTotal() + produit.getPrixUnitaire() * quantite);
            session.update(panier);

            ts.commit();
            session.close();
            System.out.println("Produit ajouté avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 修改购物车中商品的数量（加）
    public static void addQuantitePro(int idUser, int idPro){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Panier panier = getPanierByIdClient(idUser);

            if (panier == null) {
                System.out.println("Panier non trouvé pour l'utilisateur avec l'ID " + idUser);
                transaction.commit();
                session.close();
                return;
            }

            Query<Composer> query = session.createQuery("FROM Composer WHERE panier.idPanier = :panierId AND produit.idPro = :productId", Composer.class);
            query.setParameter("panierId", panier.getIdPanier());
            query.setParameter("productId", idPro);

            Composer composer = query.uniqueResult();

            composer.setQuantiteP(composer.getQuantiteP()+1);

            Produit produit = findById(composer.getIdPro());
            panier.setPrixTotal(panier.getPrixTotal() + (produit.getPrixUnitaire() * composer.getQuantiteP()));
            session.update(panier);
            session.update(composer);

            transaction.commit();
            session.close();
            System.out.println("Quantité modifiée avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 修改购物车中商品的数量（减）
    public static void reduceQuantitePro(int idUser, int idPro){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Panier panier = getPanierByIdClient(idUser);

            if (panier == null) {
                System.out.println("Panier non trouvé pour l'utilisateur avec l'ID " + idUser);
                transaction.commit();
                session.close();
                return;
            }

            Query<Composer> query = session.createQuery("FROM Composer WHERE panier.idPanier = :panierId AND produit.idPro = :productId", Composer.class);
            query.setParameter("panierId", panier.getIdPanier());
            query.setParameter("productId", idPro);

            Composer composer = query.uniqueResult();

            composer.setQuantiteP(composer.getQuantiteP()-1);

            Produit produit = findById(composer.getIdPro());
            panier.setPrixTotal(panier.getPrixTotal() + (produit.getPrixUnitaire() * composer.getQuantiteP()));

            session.update(panier);
            session.update(composer);
            transaction.commit();
            session.close();
            System.out.println("Quantité modifiée avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 清空购物车
    public void clearCart(int idUser) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Panier panier = getPanierByIdClient(idUser);

            if (panier == null) {
                System.out.println("Panier non trouvé pour l'utilisateur avec l'ID " + idUser);
                transaction.commit();
                session.close();
                return;
            }

            Query<Composer> query = session.createQuery("DELETE FROM Composer WHERE panier.idPanier = :panierId", Composer.class);
            query.setParameter("panierId", panier.getIdPanier());
            int deletedCount = query.executeUpdate();

            panier.setPrixTotal(0);
            panier.setStatut("Vide");

            session.update(panier);
            transaction.commit();
            session.close();
            System.out.println("Panier vide avec succès pour l'utilisateur " + idUser + ". " + deletedCount + " produits supprimés.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 删除购物车
    public static void deletePanier(Panier panier){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction ts = session.beginTransaction();
            session.delete(panier);
            ts.commit();
            session.close();
            System.out.println("Panier enregistré avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
