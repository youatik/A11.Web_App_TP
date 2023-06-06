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

import models.*;

public class TestClientDAO {
    private DataSource dataSource;

    public TestClientDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Client getFirstClient() {
        Client client = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Test_Projet.client LIMIT 1");
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int clientId = resultSet.getInt("clientId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                client = new Client(clientId, firstName, lastName, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }
}
