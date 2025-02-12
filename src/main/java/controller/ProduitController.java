package controller;

import metier.Produit;
import dao.ProduitDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

@WebServlet("/ProduitController")
public class ProduitController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProduitController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 根据需求选择对应的 action
        String action = request.getParameter("action");
        if (action == null) {
            viewAllProducts(request, response); // 这里缺少了分号
        } else if ("Probyid".equals(action)) {
            viewProductDetails(request, response);
        } else if ("searchProduit".equals(action)) {
            rechercherParMot(request, response);
        }

    }

    private void viewAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> produits = ProduitDao.findAll();  // 获取所有产品
        request.setAttribute("produits", produits);  // 将产品列表传递给 JSP 页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);  // 转发请求到 index.jsp
    }

    // find by id
    public void viewProductDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProStr = request.getParameter("idPro");

        if (idProStr != null && !idProStr.isEmpty()) {
            try {
                int idPro = Integer.parseInt(idProStr);

                Produit produit = ProduitDao.findById(idPro);

                if (produit != null) {
                    request.setAttribute("produit", produit);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.getWriter().println("Produit not found");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid product ID");
            }
        } else {
            response.getWriter().println("Product ID is required");
        }
    }

    public void viewProductsByLibelle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libellePro = request.getParameter("libellePro");

        if (libellePro != null && !libellePro.isEmpty()) {
            List<Produit> produits = ProduitDao.findByLibelle(libellePro);

            if (!produits.isEmpty()) {
                request.setAttribute("produits", produits);
                RequestDispatcher dispatcher = request.getRequestDispatcher("listProduits.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("Aucun produit trouvé pour le libelle : " + libellePro);
            }
        } else {
            response.getWriter().println("Le libelle du produit est requis.");
        }
    }

    public void rechercherParMot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        if (keyword == null || keyword.trim().isEmpty()) {
            response.setContentType("application/json");
            response.getWriter().write("[]");
            return;
        }

        List<Produit> produits = ProduitDao.RechercherParMotCle(keyword);

        Gson gson = new Gson();
        String json = gson.toJson(produits);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

