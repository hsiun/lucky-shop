package com.growdane.exercise.servlet.product;

import com.growdane.exercise.dao.CategoryDao;
import com.growdane.exercise.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 20:48
 */


@WebServlet("/manager/admin_toaddproduct")
public class ToAddProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> plist = CategoryDao.selectCategoryList("0");
        List<Category> clist = CategoryDao.selectCategoryList("1");
        System.out.println("clist = " + clist.size());
        System.out.println("plist = " + plist.size());
        req.setAttribute("plist", plist);
        req.setAttribute("clist", clist);

        req.getRequestDispatcher("admin_addproduct.jsp").forward(req, resp);


    }
}
