package com.growdane.exercise.servlet.user;

import com.growdane.exercise.dao.UserDao;
import com.growdane.exercise.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 14:02
 */

@WebServlet("/manager/adminlogin")
public class LoginAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int count = UserDao.countUser(username, password);
        if (count > 0) {
            User user = UserDao.selectUser(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("login", "true");
            resp.sendRedirect("admin_index.jsp");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户登陆失败');");
            writer.write("location.href='admin_login.jsp'");
            writer.write("</script>");
        }

    }
}
