/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

import data.*;
import models.*;

public class TestClientServlet4 extends HttpServlet {
    private ClientDAOImplementation clientDAOImplementation;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = TomcatDataSource.getDataSource();
        clientDAOImplementation = new ClientDAOImplementation(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = clientDAOImplementation.getClientById(1);

        request.setAttribute("client", client);
        request.getRequestDispatcher("/resultTestClient3.jsp").forward(request, response);
    }
}
