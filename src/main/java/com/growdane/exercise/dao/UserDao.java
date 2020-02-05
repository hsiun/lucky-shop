package com.growdane.exercise.dao;

import com.growdane.exercise.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author growdane@gmail.com
 * @date 2020-01-28 22:04
 */

public class UserDao {

    public static int insert(User user) {
        String id = UUID.randomUUID().toString();
        String sql = "insert into lucky_user values(?, ?, ?, ?, ?, date_format(?, '%Y-%m-%d'))";
        System.out.println(id + user.getUserName());
        return BaseDao.executeUpdate(sql, new Object[]{
                id,
                user.getUserName(),
                user.getUserPassword(),
                user.getUserMobile(),
                user.getUserAddress(),
                user.getUserBirthday()});
    }


    public static List<User> selectAll(int cpage, int count, String keyword) {
        List<User> users = new ArrayList<>();
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (keyword == null || keyword.length() == 0) {
                sql = "select * from lucky_user order by user_birthday desc limit ?, ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, (cpage-1) * count);
                preparedStatement.setInt(2, count);
            } else {
                sql = "select * from lucky_user where user_name like ? order by user_birthday desc limit ?, ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%"+keyword+"%");
                preparedStatement.setInt(2, (cpage-1) * count);
                preparedStatement.setInt(3, count);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userName = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                String userMobile = resultSet.getString("user_mobile");
                String userAddress = resultSet.getString("user_address");
                String userBirthday = resultSet.getString("user_birthday");
                User user = new User(id, userName, userPassword, userMobile, userAddress, userBirthday);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return users;
    }

    public static int[] totalPage(int count, String keyword) {
        int[] ret = new int[] {0, 1};
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = null;
        try {
            if (keyword == null || keyword.length() == 0) {
                sql = "select count(*) from lucky_user";
                preparedStatement = connection.prepareStatement(sql);
            } else {
                sql = "select count(*) from lucky_user where user_name like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + keyword + "%");
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ret[0] = resultSet.getInt(1);

                if (ret[0] % count == 0) {
                    ret[1] = ret[0]/count;
                } else {
                    ret[1] = ret[0]/count + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return ret;
    }

    /**
     * 根据用户Id查询用户
     * @param id
     * @return
     */
    public static User selectById(String id) {
        User user = null;
        String sql;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                sql = "select u.*, date_format(u.user_birthday, '%Y-%m-%d') birthday from lucky_user u where id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                String userMobile = resultSet.getString("user_mobile");
                String userAddress = resultSet.getString("user_address");
                String userBirthday = resultSet.getString("birthday");
                user = new User(id, userName, userPassword, userMobile, userAddress, userBirthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return user;
    }

    public static int update(User user) {
        String sql = "update lucky_user set user_name = ?, user_password = ?, user_mobile = ?, user_address = ?, user_birthday = ? where id = ?";


        return BaseDao.executeUpdate(sql, new Object[]{
                user.getUserName(),
                user.getUserPassword(),
                user.getUserMobile(),
                user.getUserAddress(),
                user.getUserBirthday(),
                user.getID()
        });
    }

    public static int deleteById(String id) {
        String sql = "delete from lucky_user  where id = ?";
        Object[] parm = new Object[] {id};
        return BaseDao.executeUpdate(sql, parm);
    }

    public static int countUser(String username, String password) {
        int count = 0;
        String sql;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            sql = "select count(*) from lucky_user u where user_name = ? and user_password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return count;
    }

    public static User selectUser(String username, String password) {
        User user = null;
        String sql;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            sql = "select u.*, date_format(u.user_birthday, '%Y-%m-%d') birthday from lucky_user u where user_name = ? and user_password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userName = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                String userMobile = resultSet.getString("user_mobile");
                String userAddress = resultSet.getString("user_address");
                String userBirthday = resultSet.getString("birthday");
                user = new User(id, userName, userPassword, userMobile, userAddress, userBirthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return user;
    }
}
