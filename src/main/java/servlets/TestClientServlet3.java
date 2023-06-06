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

import data.TestClientDAO;
import data.TomcatDataSource;
import models.*;

public class TestClientServlet3 extends HttpServlet {
    private TestClientDAO testClientDAO;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = TomcatDataSource.getDataSource();
        testClientDAO = new TestClientDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = testClientDAO.getFirstClient();

        request.setAttribute("client", client);
        request.getRequestDispatcher("/resultTestClient.jsp").forward(request, response);
    }
}
