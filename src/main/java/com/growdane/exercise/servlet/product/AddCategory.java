package com.growdane.exercise.servlet.product;

import com.growdane.exercise.dao.ProductDao;
import com.growdane.exercise.entity.Product;
import com.jspsmart.upload.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 20:48
 */


@WebServlet("/manager/admin_addproduct")
public class AddCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(this.getServletConfig(), req, resp);
        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Files files = smartUpload.getFiles();
        File file = files.getFile(0);
        String fileName = file.getFileName();

        try {
            smartUpload.save("images/product");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        Request request = smartUpload.getRequest();
        String tagId = request.getParameter("tagId");
        String productName = request.getParameter("productName");
        String productDes = request.getParameter("productDes");
        String productPrice = request.getParameter("productPrice");
        String productStock = request.getParameter("productStock");


        Product product = new Product(UUID.randomUUID().toString(),
                productName,
                productDes,
                Float.parseFloat(productPrice),
                Float.parseFloat(productStock),
                tagId.split("\\|")[0],
                tagId.split("\\|")[1],
                fileName
        );
        int count = ProductDao.insert(product);

        if (count > 0) {
            resp.sendRedirect("admin_selectproduct");
        } else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('产品添加失败')");
            out.write("location.href='manage/admin_toaddproduct'");
            out.write("</script>");

        }
    }

}
