<%-- 
    Document   : TestClientResultGetAll
    Created on : Jun 6, 2023, 8:20:43 p.m.
    Author     : youatik
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Clients</title>
</head>
<body>
    <table border="1" style="border-collapse: separate;">
        <tr>
            <th width="100">Client ID</th>
            <th width="150">First Name</th>
            <th width="150">Last Name</th>
            <th width="200">Email</th>
            <th width="250">Address</th>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.clientId}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.email}</td>
                <td>${client.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

