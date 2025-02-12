package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false); // 不创建新 session

        // 获取当前访问的路径
        String path = req.getRequestURI();

        // 如果访问的是登录页面或资源文件（如 CSS、JS），直接放行
        if (path.endsWith("login1.jsp") || path.endsWith("login") || path.contains("/css/") || path.contains("/js/")) {
            chain.doFilter(request, response);
            return;
        }

        // 检查用户是否已登录
        if (session == null || session.getAttribute("utilisateur") == null) {
            res.sendRedirect(req.getContextPath() + "/jsp/login1.jsp"); // 未登录，跳转到登录页
        } else {
            chain.doFilter(request, response); // 用户已登录，继续执行请求
        }
    }

    @Override
    public void destroy() {
        // 过滤器销毁（可选）
    }
}