package com.growdane.exercise.dao;

import com.growdane.exercise.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author growdane@gmail.com
 * @date 2020-01-31 17:33
 */

public class CategoryDao {
    public static List<Category> selectAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from lucky_category";

        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String cateName = resultSet.getString("cate_name");
                String cateParnetName = resultSet.getString("cate_parnet_name");
                Category category = new Category(id, cateName, cateParnetName);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return categories;
    }

    public static int insert(String parentId, String name) {
        String id = UUID.randomUUID().toString();
        String sql = "INSERT INTO `lucky_shop`.`lucky_category`(`id`, `cate_name`, `cate_parnet_name`) VALUES (?, ?, ?)";
        return BaseDao.executeUpdate(sql, new Object[]{
                id,
                name,
                parentId});
    }


    public static Category selectCategoryById(String id) {
        Category category = null;
        String sql;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            sql = "select * from lucky_category where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cateName = resultSet.getString("cate_name");
                String cateParnetName = resultSet.getString("cate_parnet_name");
                category = new Category(id, cateName, cateParnetName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return category;
    }

    public static int update(String id, String parentId, String name) {
        String sql = "UPDATE `lucky_shop`.`lucky_category` SET `cate_name` = ?, `cate_parnet_name` = ? WHERE `id` = ?";

        return BaseDao.executeUpdate(sql, new Object[]{
                name,
                parentId,
                id
        });
    }

    public static int deleteById(String id) {

        String sql = "delete from lucky_category where id=?";
        return BaseDao.executeUpdate(sql, new Object[]{
                id
        });
    }

    public static List<Category> selectCategoryList(String s) {
        List<Category> categories = new ArrayList<>();
        String sql = null;
        if ("0".equals(s)) {
            sql = "select * from lucky_category where cate_parnet_name = '0'";
        } else {
            sql = "select * from lucky_category where cate_parnet_name != '0'";
        }

        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String cateName = resultSet.getString("cate_name");
                String cateParnetName = resultSet.getString("cate_parnet_name");
                Category category = new Category(id, cateName, cateParnetName);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return categories;
    }


}
