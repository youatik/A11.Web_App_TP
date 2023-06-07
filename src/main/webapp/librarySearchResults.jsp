<%-- 
    Document   : librarySearchResults.jsp
    Created on : Jun 7, 2023, 3:07:10?p.m.
    Author     : youatik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Search Results</title>
</head>
<body>
    <h1>Library Search Results</h1>

    <c:if test="${empty searchResults}">
        <p>No results found.</p>
    </c:if>

    <c:if test="${not empty searchResults}">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Creator</th>
                <th>Description</th>
            </tr>
            <c:forEach var="library" items="${searchResults}">
                <tr>
                    <td>${library.eanIsbn13}</td>
                    <td>${library.title}</td>
                    <td>${library.creators}</td>
                    <td>${library.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>

