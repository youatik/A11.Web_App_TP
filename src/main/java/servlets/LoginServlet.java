/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import data.ClientDAOImplementation;
import data.TomcatDataSource;
import data.UserAuthenticationDAOImplementation;
import models.Client;
import models.UserAuthentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.sql.DataSource;

public class LoginServlet extends HttpServlet {
    private UserAuthenticationDAOImplementation userAuthenticationDAO;
    private ClientDAOImplementation clientDAO;

    public void init() {
        DataSource dataSource = TomcatDataSource.getDataSource();
        userAuthenticationDAO = new UserAuthenticationDAOImplementation(dataSource);
        clientDAO = new ClientDAOImplementation(dataSource);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials
        
        UserAuthentication userAuth = userAuthenticationDAO.getUserAuthenticationByCredentials(username, password);

        if (userAuth != null) {
            int clientId = userAuth.getClientId();
            // Retrieve the client object based on the clientId
            Client client = clientDAO.getClientById(clientId);

            if (client != null) {
                // Create a session and store the client object in it
                HttpSession session = request.getSession();
                session.setAttribute("client", client);

                // Redirect to the login successful page
                response.sendRedirect("login-success.jsp");
            } else {
                // Redirect back to the login page with an error message
                response.sendRedirect("login.jsp?error=2");
            }
        } else {
            // Redirect back to the login page with an error message
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
