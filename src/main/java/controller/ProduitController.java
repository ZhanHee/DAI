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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
        if ("viewProductDetails".equals(action)) {
            viewProductDetails(request, response);
        }
        // 其他处理逻辑
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

    public void Rechercherparmot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<mots>");

        String mot = request.getParameter("mot");
        if (mot != null && !mot.isEmpty()) {

            try {
                List<String> mots = ProduitDao.RechercherParMotCle(mot);

                if (mots != null && !mots.isEmpty()) {
                    for (String motResult : mots) {
                        out.println("<mot>" + motResult + "</mot>");
                    }
                } else {
                    out.println("<mot>Aucun résultat trouvé</mot>");
                }
            } catch (Exception ex) {
                out.println("<mot> Erreur - " + ex.getMessage() + "</mot>");
            }
        } else {
            out.println("<mot>Mot-clé requis</mot>");
        }

        out.println("</mots>");
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果需要处理 POST 请求，可以在这里添加逻辑
    }
}

