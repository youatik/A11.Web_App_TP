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

public class TestClientDAO {
    private DataSource dataSource;

    public TestClientDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getFirstClient() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Test_Projet.client LIMIT 1");
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                return "First Client: " + firstName + " " + lastName +
                        "\nEmail: " + email +
                        "\nAddress: " + address;
            }
        } catch (SQLException e) {
            // Handle the exception
        }

        return "No clients found.";
    }
}
