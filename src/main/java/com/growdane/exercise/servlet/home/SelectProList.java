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
import java.util.ArrayList;
import java.util.List;

/**
 * @author growdane@gmail.com
 * @date 2020-01-29 15:36
 */


@WebServlet("/selectprolist")
public class SelectProList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fid = req.getParameter("pid");
        String cid = req.getParameter("cid");
        String id = null;
        List<Category> plist = CategoryDao.selectCategoryList("0");
        List<Category> clist = CategoryDao.selectCategoryList("1");
        List<Product> products = new ArrayList<>();

        if (fid != null) {
            id = fid;
            products = ProductDao.selectByFid(id);
        } else if (cid != null) {
            id = cid;
            products = ProductDao.selectByCid(id);
        }

        Category category = CategoryDao.selectCategoryById(id);
        System.out.println("clist = " + clist.size());
        System.out.println("plist = " + plist.size());
        req.setAttribute("plist", plist);
        req.setAttribute("clist", clist);
        req.setAttribute("title", category.getCategoryName());
        req.setAttribute("products", products);

        req.getRequestDispatcher("proList.jsp").forward(req, resp);

    }
}
