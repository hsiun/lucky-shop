package com.growdane.exercise.servlet.cart;

import com.growdane.exercise.dao.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 20:48
 */


@WebServlet("/cartshopnumadd")
public class AjaxAddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("cid");
        String count = req.getParameter("count");
        System.out.println("count = " + count);
        System.out.println("id = " + id);
        CartDao.update(id, Integer.parseInt(count));
    }

}
