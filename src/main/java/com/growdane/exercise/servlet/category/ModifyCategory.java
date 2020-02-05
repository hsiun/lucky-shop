package com.growdane.exercise.servlet.category;

import com.growdane.exercise.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 20:48
 */


@WebServlet("/manager/admin_modifycategory")
public class ModifyCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String parentId = req.getParameter("parentId");
        String name = req.getParameter("name");
        int count = CategoryDao.update(id, parentId, name);

        if (count > 0) {
            resp.sendRedirect("admin_selectcatagroy");
        } else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('分类添加失败')");
            out.write("location.href='manage/admin_tomodifycategory'");
            out.write("</script>");

        }
    }

}
