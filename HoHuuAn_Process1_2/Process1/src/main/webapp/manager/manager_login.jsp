<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<header>
</header>
<%@include file="../component/toastMessage.jsp"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">Manager Login</h3>
            <form action="login" method="post" class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light">
                <div class="form-group">
                    <label for="username">Email</label>
                    <input value="<c:out value="${requestScope.username}"/>" id="username" name="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input value="<c:out value="${requestScope.password}"/>" id="password" name="password" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5">Login</button>
                </div>
                <c:if test="${not empty sessionScope.error}">
                    <div class="form-group">
                        <div class="alert alert-danger"><c:out value="${sessionScope.error}"/></div>
                    </div>
                </c:if>

                <c:remove var="error" scope="session"/>
                <div class="form-group">
                    <p>Haven't you have an account? <a href="/register">Register</a></p>
                </div>
            </form>

        </div>
    </div>
</div>
</body>