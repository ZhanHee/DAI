package controller;


import dao.utilisateurDao;
import metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class userController {
    private static final long seralVersionUID = 1L;
    private utilisateurDao utilisateurdao;

    public void init() throws ServletException{
        utilisateurdao = new utilisateurDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Utilisateur utilisateur = utilisateurdao.verifierUtilisateur(email, password);

        //vers front
        if(utilisateur != null){
            request.getSession().setAttribute("utilisateur", utilisateur);
            response.sendRedirect("home.html");
        }else{
            request.setAttribute("errorMessage", "username ou password invalide");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    public void destroy(){
        utilisateurdao = null;
    }

}
