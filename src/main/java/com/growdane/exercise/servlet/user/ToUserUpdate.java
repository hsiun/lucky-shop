package com.growdane.exercise.servlet.user;

import com.growdane.exercise.dao.UserDao;
import com.growdane.exercise.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author growdane@gmail.com
 * @date 2020-01-30 10:24
 */


@WebServlet("/manager/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cp = req.getParameter("cp");
        String id = req.getParameter("id");

        System.out.println("id = " + id);
        User user = UserDao.selectById(id);
        System.out.println("users = " + user.toString());

        //把结果放到请求中返回
        req.setAttribute("user", user);
        req.getRequestDispatcher("admin_modify.jsp?" +"cp=" + cp).forward(req, resp);
    }
}
