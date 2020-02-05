package com.growdane.exercise.servlet.category;

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


@WebServlet("/manager/admin_tomodifycategory")
public class ToModifyCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Category> categorys = CategoryDao.selectAll();
        Category cate = CategoryDao.selectCategoryById(id);
        System.out.println("ToAddCategory = " + categorys.size());

        //把结果放到请求中返回
        req.setAttribute("categorys", categorys);
        req.setAttribute("cate", cate);
        req.getRequestDispatcher("admin_modifycategory.jsp").forward(req, resp);


    }
}
