package com.growdane.exercise.servlet.category;

import com.growdane.exercise.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author growdane@gmail.com
 * @date 2020-01-30 13:38
 */

@WebServlet("/manager/admin_delcategory")
public class DeleteCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println("id = " + id);
        int count = CategoryDao.deleteById(id);

        //把结果放到请求中返回
        req.getRequestDispatcher("/manager/admin_selectcatagroy").forward(req, resp);
    }
}
