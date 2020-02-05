package com.growdane.exercise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author growdane@gmail.com
 * @date 2020-01-28 20:10
 */


@WebFilter("/manager/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String uri = req.getRequestURI().substring(req.getContextPath().length());
        System.out.println("uri = " + uri);

        HttpSession session = req.getSession();
        String login = (String)session.getAttribute("login");
        if (uri.contains("admin") && uri.contains("login")) {
            chain.doFilter(req, resp);
        } else {
            if ("true".equals(login)) {
                chain.doFilter(req, resp);
            } else {
                PrintWriter writer = resp.getWriter();
                writer.write("<script>");
                writer.write("alert('请先登陆');");
                writer.write("location.href='admin_login.jsp';");
                writer.write("</script>");
                writer.close();
            }
        }

        return;
    }

    @Override
    public void destroy() {

    }
}
