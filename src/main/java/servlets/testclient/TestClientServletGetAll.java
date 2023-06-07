/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets.testclient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

import data.TestClientDAO;
import data.TomcatDataSource;
import models.Client;

public class TestClientServletGetAll extends HttpServlet {
    private TestClientDAO testClientDAO;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = TomcatDataSource.getDataSource();
        testClientDAO = new TestClientDAO(dataSource);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = testClientDAO.getAllClients();

        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/showAllClients.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
