package com.growdane.exercise.servlet.cart;

import com.growdane.exercise.dao.CartDao;
import com.growdane.exercise.dao.ProductDao;
import com.growdane.exercise.entity.Cart;
import com.growdane.exercise.entity.Product;
import com.growdane.exercise.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 20:48
 */


@WebServlet("/cartadd")
public class AddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        String count = req.getParameter("count");
        String url = req.getParameter("url");

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String login = (String)session.getAttribute("login");
        if ("true".equals(login) && user != null) {
            Cart oldCart = CartDao.selectByUIdAndPId(user.getID(), id);
            if (oldCart != null) {
                //更新记录
                int newCount = Integer.parseInt(count) + Integer.parseInt(oldCart.getCartQuantity());
                CartDao.update(oldCart.getId(), newCount);
            } else {

                Product product = ProductDao.selectById(id);
                Cart cart = new Cart(
                        UUID.randomUUID().toString(),
                        product.getProductFilename(),
                        product.getProductName(),
                        product.getProductPrice(),
                        count,
                        product.getProductStock(),
                        product.getId(),
                        user.getID(),
                        "1"
                );
                CartDao.insert(cart);
            }

        } else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('分类添加失败');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
        }

        if ("z".equals(url)) {
            resp.sendRedirect("showcart");
        } else {
            resp.sendRedirect("selectprolist");
        }

    }

}
