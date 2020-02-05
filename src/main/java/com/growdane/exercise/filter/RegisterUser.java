package com.growdane.exercise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author growdane@gmail.com
 * @date 2020-01-28 20:10
 */


@WebFilter("/register")
public class RegisterUser implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        PrintWriter writer = resp.getWriter();

        if ("".equals(username)) {
            writer.write("<script>");
            writer.write("alert('用户名密码不能为空');");
            writer.write("location.href='reg.jsp';");
            writer.write("</script>");
            return;
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
