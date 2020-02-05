package com.growdane.exercise.servlet.home;

import com.growdane.exercise.dao.CategoryDao;
import com.growdane.exercise.dao.ProductDao;
import com.growdane.exercise.entity.Category;
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


@WebServlet("/selectprodetail")
public class SelectProDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productId = req.getParameter("id");

        String id = null;
        List<Category> plist = CategoryDao.selectCategoryList("0");
        List<Category> clist = CategoryDao.selectCategoryList("1");



        Product product = ProductDao.selectById(productId);
        System.out.println("clist = " + clist.size());
        System.out.println("plist = " + plist.size());
        req.setAttribute("plist", plist);
        req.setAttribute("clist", clist);

        req.setAttribute("product", product);


        req.getRequestDispatcher("proDetail.jsp").forward(req, resp);

    }
}
