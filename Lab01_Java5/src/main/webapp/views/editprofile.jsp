<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register</title>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no"
  />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<body>
<div class="container">
  <section>
    <div class="row">
      <div class="col-9">
        <c:if test="${not empty message}">
        <div class="alert alert-primary text-center" role="alert">${message}</div>
        </c:if>
        <a href="http://localhost:8080/Lab01/listUser" type="button" class="btn btn-primary">User List</a>
        <form action="update" method="post">
          <div class="form-group">
            <div class="mb-3">
              <label for="email" class="form-label">Email</label>
              <input
                      value="${user.email}"
                      type="text"
                      id="email"
                      name="email"
                      class="form-control"
                      readonly
              />
            </div>
            <div class="mb-3">
              <label for="username">Name</label>
              <input
                      value="${user.name}"
                      type="text"
                      id="username"
                      name="name"
                      class="form-control"
              />
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input
                      value="${user.password}"
                      type="password"
                      id="password"
                      name="password"
                      class="form-control"
              />
            </div>
            <div class="mb-3">
              <label for="age" class="form-label">Age</label>
              <input
                      value="${user.age}"
                      type="text"
                      id="age"
                      name="age"
                      class="form-control"
              />
            </div>

            <div class="mb-3">
              <label for="note" class="form-label">Dia chi:</label>
              <textarea  class="form-control" name="address" id="note" rows="3" style="resize: none;">
                ${user.address}
              </textarea>
            </div>
            <input name="id" value="${user.id}" type="hidden">
            <button type="submit" class="btn btn-primary">Update</button>
          </div>
        </form>
      </div>

    </div>
  </section>
</div>


</body>
</html>