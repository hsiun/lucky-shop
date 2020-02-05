package com.growdane.exercise.dao;

import java.sql.*;

/**
 * @author growdane@gmail.com
 * @date 2020-01-28 21:40
 */

public class BaseDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lucky_shop?characterEncoding=UTF8&serverTimezone=UTC",
                    "root",
                    "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



    public static int executeUpdate(String sql, Object[] params) {
        int count = 0;
        Connection connection = BaseDao.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, preparedStatement, connection);
        }

        return count;
    }

    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
