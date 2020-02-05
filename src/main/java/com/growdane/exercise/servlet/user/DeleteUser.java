package com.growdane.exercise.servlet.user;

import com.growdane.exercise.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author growdane@gmail.com
 * @date 2020-01-30 13:38
 */

@WebServlet("/manager/admin_deleteuser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cp = req.getParameter("cp");
        String id = req.getParameter("id");

        System.out.println("id = " + id);
        int user = UserDao.deleteById(id);
        System.out.println("users = " + user);

        //把结果放到请求中返回
        req.setAttribute("user", user);
        req.getRequestDispatcher("/manager/admin_selectuser").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAllPara(req);
        String[] ids = req.getParameterValues("id[]");
        for (String id : ids ) {
            UserDao.deleteById(id);
        }
        resp.sendRedirect("/luckyshop/manager/admin_selectuser");    }
    /**
     * 打印所有post过来的参数
     * @param request
     */
    private void getAllPara(HttpServletRequest request) {

        Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        //queryString = queryString.substring(0, queryString.length() - 1);
        System.out.println("queryString = " + queryString);
    }
}
