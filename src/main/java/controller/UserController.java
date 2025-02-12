package controller;


import dao.UtilisateurDao;
import metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CltrUser")
public class UserController extends HttpServlet {
    private static final long seralVersionUID = 1L;
    private UtilisateurDao utilisateurDao;

    public void init() throws ServletException{
        utilisateurDao = new UtilisateurDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        System.out.println(action);
        if ("register".equalsIgnoreCase(action)) {
            registerUser(request, response);
        } else if("login".equalsIgnoreCase(action)) {
            loginUser(request, response);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Utilisateur utilisateur = UtilisateurDao.verifierUtilisateur(email, password);

        if (utilisateur != null) {
            request.getSession().setAttribute("utilisateur", utilisateur);
            response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
        } else {
            request.setAttribute("errorMessage", "user not found");
            request.getRequestDispatcher("/jsp/login1.jsp").forward(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Utilisateur newUser = new Utilisateur();
        newUser.setNomUser(name);
        newUser.setEmailUser(email);
        newUser.setMotPasse(password);

        boolean registered = UtilisateurDao.registerUtilisateur(newUser);
        if (registered) {

            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "注册失败，请重试");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    public void destroy(){
        utilisateurDao = null;
    }

}
