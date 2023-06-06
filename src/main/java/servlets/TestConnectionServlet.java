/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author youatik
 */
public class TestConnectionServlet extends HttpServlet {
    private DataSource dataSource;

    @Override
public void init() throws ServletException {
    try {
        InitialContext initialContext = new InitialContext();
        dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/Test_Projet");
    } catch (NamingException e) {
        throw new ServletException("Error initializing data source", e);
    }
}


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = dataSource.getConnection()) {
            String message = dataSource.toString();
            request.setAttribute("message", message);
        } catch (SQLException e) {
            String errorMessage = "Connection failed! " + e.getMessage();
            String stackTrace = getStackTrace(e);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("stackTrace", stackTrace);
        }

        request.getRequestDispatcher("resultTestConnection.jsp").forward(request, response);
    }

    private String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}
