/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.*;
/**
 *
 * @author youatik
 */


public class OrderItemDAOImplementation implements OrderItemDAOInterface {
    private DataSource dataSource;

    public OrderItemDAOImplementation(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Test_Projet.orderItem (orderId, ean_isbn13, quantity, price, clientId) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, orderItem.getOrderId());
            preparedStatement.setLong(2, orderItem.getEanIsbn13());
            preparedStatement.setInt(3, orderItem.getQuantity());
            preparedStatement.setBigDecimal(4, orderItem.getPrice());
            preparedStatement.setInt(5, orderItem.getClientId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Test_Projet.orderItem SET quantity = ?, price = ? WHERE id = ?")) {
            preparedStatement.setInt(1, orderItem.getQuantity());
            preparedStatement.setBigDecimal(2, orderItem.getPrice());
            preparedStatement.setInt(3, orderItem.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM Test_Projet.orderItem WHERE id = ?")) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.orderItem WHERE id = ?")) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createOrderItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.orderItem")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderItem orderItem = createOrderItemFromResultSet(resultSet);
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }

    private OrderItem createOrderItemFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int orderId = resultSet.getInt("orderId");
        long eanIsbn13 = resultSet.getLong("ean_isbn13");
        int quantity = resultSet.getInt("quantity");
        java.math.BigDecimal price = resultSet.getBigDecimal("price");
        int clientId = resultSet.getInt("clientId");

        return new OrderItem(id, orderId, eanIsbn13, quantity, price, clientId);
    }
}
