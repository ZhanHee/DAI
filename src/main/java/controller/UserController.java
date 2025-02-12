package controller;


import dao.UtilisateurDao;
import metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/CltrUser")
public class UserController extends HttpServlet {
    private static final long seralVersionUID = 1L;


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

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        Date now = new Date();

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match!");
            request.getRequestDispatcher("/jsp/creerCompte1.jsp").forward(request, response);
            return;
        }

        Utilisateur newUser = new Utilisateur(nom, prenom, email, password, now);

        try{
            if (UtilisateurDao.creerUtilisateur(newUser)) {
                request.setAttribute("successMessage", "Account created successfully! Please log in.");
                request.getRequestDispatcher("/jsp/login1.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Registration failed. Try again.");
                request.getRequestDispatcher("/jsp/creerCompte1.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("errorMessage", "An unexpected error occurred. Please try again.");
            request.getRequestDispatcher("/jsp/creerCompte1.jsp").forward(request, response);
        }
    }


}
