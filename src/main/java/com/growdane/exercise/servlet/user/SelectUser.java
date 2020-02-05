package com.growdane.exercise.servlet.user;

import com.growdane.exercise.dao.UserDao;
import com.growdane.exercise.entity.User;

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


@WebServlet("/manager/admin_selectuser")
public class SelectUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cpage = 1;
        int count = 5;
        String cp = req.getParameter("cp");
        String keyword = req.getParameter("keywords");

        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        int arr[] = UserDao.totalPage(count, keyword);

        List<User> users = UserDao.selectAll(cpage, count, keyword);
        System.out.println("users = " + users.size());

        //把结果放到请求中返回
        req.setAttribute("users", users);
        req.setAttribute("tsum", arr[0]);
        req.setAttribute("tpage", arr[1]);
        req.setAttribute("cpage", cpage);
        if (keyword != null) {
            req.setAttribute("search_keyword", "&keyword=" + keyword);
        }
        req.getRequestDispatcher("admin_user.jsp").forward(req, resp);

    }
}
