/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

import data.*;
import models.*;

import javax.sql.DataSource;
import java.util.List;

public class LibrarySearchServiceTermType {
    private LibraryDAOImplementation libraryDAO;

    public LibrarySearchServiceTermType(DataSource dataSource) {
        libraryDAO = new LibraryDAOImplementation(dataSource);
    }

    public List<Library> search(String searchType, String searchTerm) {
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

        return searchResults;
    }
}
