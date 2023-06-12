/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import data.TomcatDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

import models.*;
import search.*;

public class LibrarySearchServletTermType extends HttpServlet {
    private LibrarySearchServiceTermType searchService;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = TomcatDataSource.getDataSource();
        searchService = new LibrarySearchServiceTermType(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        List<Library> searchResults = searchService.search(searchType, searchTerm);

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("/librarySearchResults.jsp").forward(request, response);
    }
}
