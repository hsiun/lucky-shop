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
 * @date 2020-01-29 15:36
 */


@WebServlet("/manager/admin_selectcatagroy")
public class SelectCatagory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> category = CategoryDao.selectAll();

        System.out.println("category = " + category.size());

        //把结果放到请求中返回
        req.setAttribute("category", category);
        req.getRequestDispatcher("admin_category.jsp").forward(req, resp);

    }
}
