<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Search Results</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
      padding: 20px;
    }
    h1 {
      color: #343a40;
      font-size: 24px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #ced4da;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #343a40;
      color: #fff;
    }
    tr:nth-child(even) {
      background-color: #f8f9fa;
    }
  </style>
</head>
<body>
  <h1>Search Results</h1>
  <table>
    <thead>
      <tr>
        <th>Title</th>
        <th>Creator</th>
        <th>Description</th>
        <th>Editor</th>
        <th>Price</th>
        <th>Pages</th>
        <!-- Add more columns as needed -->
      </tr>
    </thead>
    <tbody>
      <c:forEach var="library" items="${searchResults}">
        <tr>
          <td>${library.title}</td>
          <td>${library.creators}</td>
          <td>${library.description}</td>
          <td>${library.publisher}</td>
          <td>${library.price}</td>
          <td>${library.length}</td>
          <!-- Add more cells and data as needed -->
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
