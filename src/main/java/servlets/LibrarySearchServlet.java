/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import data.*;
import models.Library;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class LibrarySearchServlet extends HttpServlet {
    private LibraryDAOImplementation libraryDAO;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = TomcatDataSource.getDataSource();
        libraryDAO = new LibraryDAOImplementation(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        List<Library> searchResults = null;

        if (searchTerm != null && !searchTerm.isEmpty()) {
            if (searchType.equals("id")) {
                long id = Long.parseLong(searchTerm);
                Library library = libraryDAO.getLibraryById(id);
                if (library != null) {
                    searchResults = List.of(library);
                }
            } else if (searchType.equals("title")) {
                searchResults = libraryDAO.findByTitle(searchTerm);
            } else if (searchType.equals("creator")) {
                searchResults = libraryDAO.findByCreators(searchTerm);
            } else if (searchType.equals("description")) {
                searchResults = libraryDAO.findByDescription(searchTerm);
            }
        }

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("/librarySearchResults.jsp").forward(request, response);
    }
}

