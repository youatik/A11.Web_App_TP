/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestClientServlet extends HttpServlet {
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            // Lookup the data source from the JNDI context
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/Test_Projet");
        } catch (NamingException e) {
            throw new ServletException("Error initializing data source", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = getFirstClient();

        request.setAttribute("result", result);
        request.getRequestDispatcher("/resultTestClient.jsp").forward(request, response);
    }

    private String getFirstClient() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Get connection from the data source
            connection = dataSource.getConnection();

            // Prepare and execute SQL statement to get the first client
            statement = connection.prepareStatement("SELECT * FROM Test_Projet.client LIMIT 1");
            resultSet = statement.executeQuery();

            // Process the result set
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
        } finally {
            // Close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // Handle the exception
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Handle the exception
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Handle the exception
                }
            }
        }

        return "No clients found.";
    }
}
