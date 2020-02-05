package com.growdane.exercise.servlet.product;

import com.growdane.exercise.dao.ProductDao;
import com.growdane.exercise.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author growdane@gmail.com
 * @date 2020-01-29 15:36
 */


@WebServlet("/manager/admin_selectproduct")
public class SelectProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductDao.selectAll();
        for (Product product:products) {
            System.out.println("product = " + product);
        }

        //把结果放到请求中返回
        req.setAttribute("products", products);
        req.getRequestDispatcher("admin_product.jsp").forward(req, resp);

    }
}
