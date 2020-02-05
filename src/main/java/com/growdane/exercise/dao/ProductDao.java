package com.growdane.exercise.dao;

import com.growdane.exercise.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author growdane@gmail.com
 * @date 2020-01-28 22:04
 */

public class ProductDao {

    public static int insert(Product product) {
        String sql = "INSERT INTO `lucky_shop`.`lucky_product`(`id`, `product_name`, `product_des`, `product_price`, `product_stock`, `product_fid`, `product_cid`, `product_filename`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return BaseDao.executeUpdate(sql, new Object[]{
                product.getId(),
                product.getProductName(),
                product.getProductDes(),
                product.getProductPrice(),
                product.getProductStock(),
                product.getProductFid(),
                product.getProductCid(),
                product.getProductFilename()
        });
    }

    public static List<Product> selectAll( ){
        List<Product> products = new ArrayList<>();
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

                sql = "select * from lucky_product";
                preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String product_name = resultSet.getString("product_name");
                String product_des = resultSet.getString("product_des");
                Float product_price = resultSet.getFloat("product_price");
                Float product_stock = resultSet.getFloat("product_stock");
                String product_fid = resultSet.getString("product_fid");
                String product_cid = resultSet.getString("product_cid");
                String product_filename = resultSet.getString("product_filename");
                Product product = new Product(id, product_name, product_des, product_price, product_stock, product_fid, product_cid, product_filename);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return products;
    }

    public static List<Product> selectByFid(String id) {
        List<Product> products = new ArrayList<>();
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            sql = "select * from lucky_product where product_fid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String pid = resultSet.getString("id");
                String product_name = resultSet.getString("product_name");
                String product_des = resultSet.getString("product_des");
                Float product_price = resultSet.getFloat("product_price");
                Float product_stock = resultSet.getFloat("product_stock");
                String product_fid = resultSet.getString("product_fid");
                String product_cid = resultSet.getString("product_cid");
                String product_filename = resultSet.getString("product_filename");
                Product product = new Product(pid, product_name, product_des, product_price, product_stock, product_fid, product_cid, product_filename);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return products;
    }

    public static List<Product> selectByCid(String id) {
        List<Product> products = new ArrayList<>();
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            sql = "select * from lucky_product where product_cid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String pid = resultSet.getString("id");
                String product_name = resultSet.getString("product_name");
                String product_des = resultSet.getString("product_des");
                Float product_price = resultSet.getFloat("product_price");
                Float product_stock = resultSet.getFloat("product_stock");
                String product_fid = resultSet.getString("product_fid");
                String product_cid = resultSet.getString("product_cid");
                String product_filename = resultSet.getString("product_filename");
                Product product = new Product(pid, product_name, product_des, product_price, product_stock, product_fid, product_cid, product_filename);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return products;
    }

    public static Product selectById(String productId) {
        Product product = null;
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            sql = "select * from lucky_product where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, productId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String pid = resultSet.getString("id");
                String product_name = resultSet.getString("product_name");
                String product_des = resultSet.getString("product_des");
                Float product_price = resultSet.getFloat("product_price");
                Float product_stock = resultSet.getFloat("product_stock");
                String product_fid = resultSet.getString("product_fid");
                String product_cid = resultSet.getString("product_cid");
                String product_filename = resultSet.getString("product_filename");
                product = new Product(pid, product_name, product_des, product_price, product_stock, product_fid, product_cid, product_filename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return product;
    }
}
