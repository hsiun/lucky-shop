package com.growdane.exercise.dao;

import com.growdane.exercise.entity.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author growdane@gmail.com
 * @date 2020-02-04 21:14
 */

public class CartDao {
    public static int insert(Cart cart) {
        String sql = "insert into lucky_cart values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return BaseDao.executeUpdate(sql, new Object[]{
                cart.getId(),
                cart.getCartPFilename(),
                cart.getCartPName(),
                cart.getCartPPrice(),
                cart.getCartQuantity(),
                cart.getCartPStock(),
                cart.getCartPId(),
                cart.getCartUId(),
                cart.getCartValid()
        });
    }

    public static List<Cart> selectByUserId(String id) {
        List<Cart> carts = new ArrayList<>();
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            sql = "select * from lucky_cart where cart_u_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cid = resultSet.getString("id");
                String cartPFilename = resultSet.getString("cart_p_filename");
                String cartPName = resultSet.getString("cart_p_name");
                Float cartPPrice = resultSet.getFloat("cart_p_price");
                String cartQuantity = resultSet.getString("cart_quantity");
                Float cartPStock = resultSet.getFloat("cart_p_stock");
                String cartPId = resultSet.getString("cart_p_id");
                String cartUId = resultSet.getString("cart_u_id");
                String cartValid = resultSet.getString("cart_valid");
                Cart cart = new Cart(cid, cartPFilename, cartPName, cartPPrice, cartQuantity, cartPStock, cartPId, cartUId, cartValid);

                carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return carts;
    }

    public static Cart selectByUIdAndPId(String uid, String pid) {
        Cart cart = null;
        String sql = null;
        Connection connection = BaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            sql = "select * from lucky_cart where cart_u_id = ? and  cart_p_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, uid);
            preparedStatement.setObject(2, pid);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cid = resultSet.getString("id");
                String cartPFilename = resultSet.getString("cart_p_filename");
                String cartPName = resultSet.getString("cart_p_name");
                Float cartPPrice = resultSet.getFloat("cart_p_price");
                String cartQuantity = resultSet.getString("cart_quantity");
                Float cartPStock = resultSet.getFloat("cart_p_stock");
                String cartPId = resultSet.getString("cart_p_id");
                String cartUId = resultSet.getString("cart_u_id");
                String cartValid = resultSet.getString("cart_valid");
                cart = new Cart(cid, cartPFilename, cartPName, cartPPrice, cartQuantity, cartPStock, cartPId, cartUId, cartValid);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }

        return cart;
    }

    public static int update(String id, int newCount) {
        String sql = "update lucky_cart set cart_quantity = ? where id = ?";
        return BaseDao.executeUpdate(sql, new Object[]{
                newCount,
                id
        });
    }
}
