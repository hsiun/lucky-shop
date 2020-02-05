package com.growdane.exercise.servlet.cart;

import com.growdane.exercise.dao.CartDao;
import com.growdane.exercise.entity.Cart;
import com.growdane.exercise.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 20:48
 */


@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String login = (String)session.getAttribute("login");
        if ("true".equals(login) && user != null) {
            List<Cart> carts = CartDao.selectByUserId(user.getID());
            System.out.println("carts = " + carts);
            req.setAttribute("carts", carts);
            req.getRequestDispatcher("cart.jsp").forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('分类添加失败');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
        }
    }

}
