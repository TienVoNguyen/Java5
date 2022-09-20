<%--
  Created by IntelliJ IDEA.
  User: VoNT
  Date: 14/09/2022
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>password</th>
            <th>age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}" >
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.address}</td>
            <td>${user.address}</td>
            <td><a class="btn btn-info" href="http://localhost:8080/Lab01/update?id=${user.id}">Edit</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
