package com.growdane.exercise.servlet.user;

import com.growdane.exercise.dao.UserDao;
import com.growdane.exercise.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author growdane@gmail.com
 * @date 2020-01-28 20:10
 */


@WebServlet("/manager/admin_adduser")
public class DoUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");

        User user = new User(username, password, mobile, address, birthday);
        //加入数据库中
        System.out.println("user.toString() = " + user.toString());
        int count = UserDao.insert(user);
        //判断添加成功还是失败
        if (count > 0) {
            resp.sendRedirect("admin_selectuser");
        } else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('用户添加失败')");
            out.write("location.href='manage/admin_insert.jsp'");
            out.write("</script>");

        }
    }

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
