package dao;

import metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class PanierDao {

    // 获取当前用户id的购物车
    public static Panier getPanierByIdClient(int idUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Panier> query = session.createQuery("FROM Panier WHERE idUser = :id", Panier.class);
            query.setParameter("id", idUser);
            Panier panier = query.uniqueResult();
            return panier;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 获取购物车中所有商品
    public static List<Composer> getProductsInPanier(int idUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Panier panier = getPanierByIdClient(idUser);
            if (panier != null) {
                Query<Composer> query = session.createQuery("FROM Composer WHERE panier.idPanier = :panierId", Composer.class);
                query.setParameter("panierId", panier.getIdPanier());
                return query.list();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 添加商品到购物车
    public static void addProduitToPanier(int idUser, int idPro, int quantite) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction ts = session.beginTransaction();
            Panier panier = getPanierByIdClient(idUser);

            if (panier == null) {
                panier = new Panier();
                panier.setStatut("En cours");
                panier.setPrixTotal(0);
                panier.setClient(session.get(Client.class, idUser));
                session.save(panier);
            }

            Produit produit = session.get(Produit.class, idPro);
            Query<Composer> query = session.createQuery("FROM Composer WHERE panier.idPanier = :panierId AND produit.idPro = :productId", Composer.class);
            query.setParameter("panierId", panier.getIdPanier());
            query.setParameter("productId", idPro);

            Composer composer = query.uniqueResult();

            if (composer != null) {
                // 商品已在购物车中，增加数量
                composer.setQuantiteP(composer.getQuantiteP() + quantite);
            } else {
                // 新商品加入购物车
                ComposerId composerId = new ComposerId(produit.getIdPro(), panier.getIdPanier());
                composer = new Composer();
                composer.setId(composerId);
                composer.setQuantiteP(quantite);
                session.save(composer);
            }

            panier.setPrixTotal(panier.getPrixTotal() + produit.getPrixUnitaire() * quantite);
            session.update(panier);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 修改购物车中商品的数量（加）
    public static void addQuantitePro(int idUser, int idPro) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction ts = session.beginTransaction();
            Panier panier = getPanierByIdClient(idUser);
            if (panier != null) {
                Query<Composer> query = session.createQuery("FROM Composer WHERE panier.idPanier = :panierId AND produit.idPro = :productId", Composer.class);
                query.setParameter("panierId", panier.getIdPanier());
                query.setParameter("productId", idPro);
                Composer composer = query.uniqueResult();
                if (composer != null) {
                    composer.setQuantiteP(composer.getQuantiteP() + 1);
                    Produit produit = session.get(Produit.class, idPro);
                    panier.setPrixTotal(panier.getPrixTotal() + produit.getPrixUnitaire());
                    session.update(panier);
                    session.update(composer);
                    ts.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 修改购物车中商品的数量（减）
    public static void reduceQuantitePro(int idUser, int idPro) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction ts = session.beginTransaction();
            Panier panier = getPanierByIdClient(idUser);
            if (panier != null) {
                Query<Composer> query = session.createQuery("FROM Composer WHERE panier.idPanier = :panierId AND produit.idPro = :productId", Composer.class);
                query.setParameter("panierId", panier.getIdPanier());
                query.setParameter("productId", idPro);
                Composer composer = query.uniqueResult();
                if (composer != null) {
                    composer.setQuantiteP(composer.getQuantiteP() - 1);
                    Produit produit = session.get(Produit.class, idPro);
                    panier.setPrixTotal(panier.getPrixTotal() - produit.getPrixUnitaire());
                    session.update(panier);
                    session.update(composer);
                    ts.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 清空购物车
    public static void clearPanier(int idUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction ts = session.beginTransaction();
            Panier panier = getPanierByIdClient(idUser);
            if (panier != null) {
                Query<Composer> query = session.createQuery("DELETE FROM Composer WHERE panier.idPanier = :panierId", Composer.class);
                query.setParameter("panierId", panier.getIdPanier());
                query.executeUpdate();
                panier.setPrixTotal(0);
                panier.setStatut("Vide");
                session.update(panier);
                ts.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 删除购物车
    public static void deletePanier(Panier panier) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction ts = session.beginTransaction();
            session.delete(panier);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
