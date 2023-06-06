<%-- 
    Document   : resultTestConnection
    Created on : Jun 6, 2023, 4:20:59 p.m.
    Author     : youatik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Test Connection Result</title>
</head>
<body>
    <h1>Test Connection Result</h1>
    <% if (request.getAttribute("message") != null) { %>
        <p><strong>Connection successful!</strong></p>
        <p>JDNI Ressource: <%= request.getAttribute("message") %></p> <!-- Added this line -->
    <% } else if (request.getAttribute("errorMessage") != null) { %>
        <p><strong>Connection failed!</strong></p>
        <p>Error message: <%= request.getAttribute("errorMessage") %></p>
    <% } %>
</body>
</html>

