<%-- 
    Document   : resultTestClient3
    Created on : Jun 6, 2023, 7:47:02 p.m.
    Author     : youatik
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <table border="1">
        <tr>
            <th width="150">Client</th>
        </tr>
        <tr>
            <td>
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Address</th>
                    </tr>
                    <tr>
                        <td>${client.firstName}</td>
                        <td>${client.lastName}</td>
                        <td>${client.email}</td>
                        <td>${client.address}</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>
