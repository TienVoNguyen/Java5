<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <form action="user" method="post">
        <div class="mb-3 mt-3">
            <label for="email">Email:</label>
            <input value="${email}" type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            <span>${message}</span>
        </div>
        <div class="mb-3">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
            <span>${messagePass}</span>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <a type="button" class="btn btn-info" href="http://localhost:8080/Lab01/register">Dang ky</a>
    </form>

</div>
</body>
</html>