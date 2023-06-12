/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import models.Library;

public class LibraryDAOImplementation implements LibraryDAOInterface {
    private DataSource dataSource;

    public LibraryDAOImplementation(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addLibrary(Library library) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Test_Projet.library (ean_isbn13, title, creators, firstName, lastName, description, publisher, publishDate, price, length) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setLong(1, library.getEanIsbn13());
            preparedStatement.setString(2, library.getTitle());
            preparedStatement.setString(3, library.getCreators());
            preparedStatement.setString(4, library.getFirstName());
            preparedStatement.setString(5, library.getLastName());
            preparedStatement.setString(6, library.getDescription());
            preparedStatement.setString(7, library.getPublisher());
            preparedStatement.setDate(8, library.getPublishDate());
            preparedStatement.setBigDecimal(9, library.getPrice());
            preparedStatement.setInt(10, library.getLength());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLibrary(Library library) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Test_Projet.library SET title = ?, creators = ?, firstName = ?, lastName = ?, description = ?, publisher = ?, publishDate = ?, price = ?, length = ? WHERE ean_isbn13 = ?")) {
            preparedStatement.setString(1, library.getTitle());
            preparedStatement.setString(2, library.getCreators());
            preparedStatement.setString(3, library.getFirstName());
            preparedStatement.setString(4, library.getLastName());
            preparedStatement.setString(5, library.getDescription());
            preparedStatement.setString(6, library.getPublisher());
            preparedStatement.setDate(7, library.getPublishDate());
            preparedStatement.setBigDecimal(8, library.getPrice());
            preparedStatement.setInt(9, library.getLength());
            preparedStatement.setLong(10, library.getEanIsbn13());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLibrary(long eanIsbn13) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM Test_Projet.library WHERE ean_isbn13 = ?")) {
            preparedStatement.setLong(1, eanIsbn13);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Library getLibraryById(long eanIsbn13) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.library WHERE ean_isbn13 = ?")) {
            preparedStatement.setLong(1, eanIsbn13);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createLibraryFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Library> getAllLibraries() {
        List<Library> libraries = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.library");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                libraries.add(createLibraryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libraries;
    }

    @Override
    public List<Library> findByTitle(String word) {
        List<Library> libraries = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.library WHERE title LIKE ?")) {
            preparedStatement.setString(1, "%" + word + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                libraries.add(createLibraryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libraries;
    }

    @Override
    public List<Library> findByCreators(String word) {
        List<Library> libraries = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.library WHERE creators LIKE ?")) {
            preparedStatement.setString(1, "%" + word + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                libraries.add(createLibraryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libraries;
    }

    @Override
    public List<Library> findByDescription(String word) {
        List<Library> libraries = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Test_Projet.library WHERE description LIKE ?")) {
            preparedStatement.setString(1, "%" + word + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                libraries.add(createLibraryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libraries;
    }

    
    //put this at the very end
    private Library createLibraryFromResultSet(ResultSet resultSet) throws SQLException {
        long eanIsbn13 = resultSet.getLong("ean_isbn13");
        String title = resultSet.getString("title");
        String creators = resultSet.getString("creators");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String description = resultSet.getString("description");
        String publisher = resultSet.getString("publisher");
        java.sql.Date publishDate = resultSet.getDate("publishDate");
        java.math.BigDecimal price = resultSet.getBigDecimal("price");
        int length = resultSet.getInt("length");

        return new Library(eanIsbn13, title, creators, firstName, lastName, description, publisher, publishDate, price, length);
    }
    
    
    
    
      public List<Library> searchLibraries(String searchTerm, String searchType, String[] priceFilters, String[] pagesFilters, String[] editorFilters) {
        List<Library> libraries = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM Test_Projet.library WHERE ");
            List<Object> params = new ArrayList<>();

            if (searchType.equals("creator")) {
                queryBuilder.append("creators LIKE ?");
                params.add("%" + searchTerm + "%");
            } else if (searchType.equals("title")) {
                queryBuilder.append("title LIKE ?");
                params.add("%" + searchTerm + "%");
            } else if (searchType.equals("description")) {
                queryBuilder.append("description LIKE ?");
                params.add("%" + searchTerm + "%");
            }

            if (priceFilters != null && priceFilters.length > 0) {
                queryBuilder.append(" AND (");
                for (int i = 0; i < priceFilters.length; i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    if (priceFilters[i].equals("below40")) {
                        queryBuilder.append("price < ?");
                        params.add(new BigDecimal("40"));
                    } else if (priceFilters[i].equals("40to80")) {
                        queryBuilder.append("price >= ? AND price <= ?");
                        params.add(new BigDecimal("40"));
                        params.add(new BigDecimal("80"));
                    } else if (priceFilters[i].equals("above80")) {
                        queryBuilder.append("price > ?");
                        params.add(new BigDecimal("80"));
                    }
                }
                queryBuilder.append(")");
            }

            if (pagesFilters != null && pagesFilters.length > 0) {
                queryBuilder.append(" AND (");
                for (int i = 0; i < pagesFilters.length; i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    if (pagesFilters[i].equals("below400")) {
                        queryBuilder.append("length < ?");
                        params.add(400);
                    } else if (pagesFilters[i].equals("400to800")) {
                        queryBuilder.append("length >= ? AND length <= ?");
                        params.add(400);
                        params.add(800);
                    } else if (pagesFilters[i].equals("above800")) {
                        queryBuilder.append("length > ?");
                        params.add(800);
                    }
                }
                queryBuilder.append(")");
            }

            if (editorFilters != null && editorFilters.length > 0) {
                queryBuilder.append(" AND (");
                for (int i = 0; i < editorFilters.length; i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    if (editorFilters[i].equals("pearson")) {
                        queryBuilder.append("publisher = ?");
                        params.add("Pearson");
                    } else if (editorFilters[i].equals("prenticehall")) {
                        queryBuilder.append("publisher = ?");
                        params.add("Prentice Hall");
                    } else if (editorFilters[i].equals("oreilly")) {
                        queryBuilder.append("publisher = ?");
                        params.add("O'Reilly Media");
                    } else if (editorFilters[i].equals("addisonwesley")) {
                        queryBuilder.append("publisher = ?");
                        params.add("Addison-Wesley Professional");
                    }
                }
                queryBuilder.append(")");
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString())) {
                for (int i = 0; i < params.size(); i++) {
                    Object param = params.get(i);
                    if (param instanceof String) {
                        preparedStatement.setString(i + 1, (String) param);
                    } else if (param instanceof BigDecimal) {
                        preparedStatement.setBigDecimal(i + 1, (BigDecimal) param);
                    } else if (param instanceof Integer) {
                        preparedStatement.setInt(i + 1, (Integer) param);
                    }
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        libraries.add(createLibraryFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libraries;
    }
    
}
