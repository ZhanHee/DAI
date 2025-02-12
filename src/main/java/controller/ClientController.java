package controller;

import dao.PanierDao;
import metier.Composer;
import metier.Panier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Panier")
public class ClientController extends HttpServlet {

    // 显示购物车页面(1.3查看购物车） +  清空购物车
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int idUser = Integer.parseInt(request.getSession().getAttribute("idUser").toString());

        try{
            switch (action) {
                case "affichePanier":
                    // 展示用户的购物车内容
                    Panier panier = PanierDao.getPanierByIdClient(idUser);
                    if (panier != null) {
                        List<Composer> listeProduit = PanierDao.getProductsInPanier(panier.getIdPanier());
                        request.setAttribute("panier", panier);
                        request.setAttribute("listeProduit", listeProduit);
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/panier.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "clearPanier":
                    // 清空购物车
                    PanierDao panierDao = new PanierDao();
                    panierDao.clearPanier(idUser);
                    response.sendRedirect("Panier?action=affichePanier");
                    break;

                default:
                    // 默认操作，显示购物车
                    panier = PanierDao.getPanierByIdClient(idUser);
                    request.setAttribute("panier", panier);
                    dispatcher = request.getRequestDispatcher("/jsp/panier.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 处理表单提交请求，添加商品到购物车或更新商品数量
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int idUser = Integer.parseInt(request.getSession().getAttribute("idUser").toString());

        try{
            switch (action) {
                case "addProduit":
                    // 添加商品到购物车
                    int idPro = Integer.parseInt(request.getParameter("idPro"));
                    int quantite = Integer.parseInt(request.getParameter("quantite"));
                    PanierDao.addProduitToPanier(idUser, idPro, quantite);
                    response.sendRedirect("Panier?action=affichePanier");
                    break;

                case "updateQuantity":
                    // 更新购物车中商品的数量
                    int idProUpdate = Integer.parseInt(request.getParameter("idPro"));
                    String quantityAction = request.getParameter("quantityAction");

                    if ("increase".equals(quantityAction)) {
                        PanierDao.addQuantitePro(idUser, idProUpdate);
                    } else if ("decrease".equals(quantityAction)) {
                        PanierDao.reduceQuantitePro(idUser, idProUpdate);
                    }
                    response.sendRedirect("Panier?action=affichePanier");
                    break;

                default:
                    // 默认行为处理
                    response.sendRedirect("Panier?action=affichePanier");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}