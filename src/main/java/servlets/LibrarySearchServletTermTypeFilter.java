/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;
import models.*;

/**
 *
 * @author youatik
 */

public class LibrarySearchServletTermTypeFilter extends HttpServlet {
    private LibraryDAOImplementation libraryDAO;

    @Override
    public void init() throws ServletException {
            DataSource dataSource = TomcatDataSource.getDataSource();
            libraryDAO = new LibraryDAOImplementation(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");
        String[] priceFilters = request.getParameterValues("price");
        String[] pagesFilters = request.getParameterValues("pages");
        String[] editorFilters = request.getParameterValues("editor");

        // Perform the search using the libraryDAO
        List<Library> searchResults = libraryDAO.searchLibraries(searchTerm, searchType, priceFilters, pagesFilters, editorFilters);

        // Set the search results as an attribute in the request
        request.setAttribute("searchResults", searchResults);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("librarySearchResultsFilter.jsp");
        dispatcher.forward(request, response);
    }
}



