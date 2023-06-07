<%-- 
    Document   : login-success
    Created on : Jun 7, 2023, 4:58:10?p.m.
    Author     : youatik
--%>
<%@ page import="models.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>
</head>
<body>
    <h1>Login Successful</h1>
    <p>Welcome, ${sessionScope.client.firstName}!</p>
</body>
</html>
