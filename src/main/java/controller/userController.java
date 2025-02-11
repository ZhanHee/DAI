package controller;


import dao.UtilisateurDao;
import metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class userController {
    private static final long seralVersionUID = 1L;
    private UtilisateurDao utilisateurDao;

    public void init() throws ServletException{
        utilisateurDao = new UtilisateurDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
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
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "用户名或密码无效");
            request.getRequestDispatcher("login1.jsp").forward(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // 可在此处添加更多数据和校验

        // 创建新用户对象并设置属性
        Utilisateur newUser = new Utilisateur();
        newUser.setNomUser(name);
        newUser.setEmailUser(email);
        newUser.setMotPasse(password);

        // 调用 DAO 方法注册用户（需要在 UtilisateurDao 中实现 registerUtilisateur 方法）
        boolean registered = UtilisateurDao.registerUtilisateur(newUser);
        if (registered) {
            // 注册成功后，可跳转到登录页或直接登录
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
