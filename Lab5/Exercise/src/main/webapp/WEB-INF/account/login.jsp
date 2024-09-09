<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../error.jsp"%>
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
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form action="login" method="post" class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input value="<c:out value="${requestScope.user}"/>" id="username" name="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input value="<c:out value="${requestScope.password}"/>" id="password" name="password" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-check mb-3">
                    <input type="checkbox" name="remember" id="remember" class="form-check-input">
                    <label for="remember" class="form-check-label">Remember username & password</label>
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
                <c:remove var="user" scope="request"/>
                <c:remove var="password" scope="request"/>
                <div class="form-group">
                    <p>Already a member? <a href="${pageContext.request.contextPath}/register">Click here for register!</a></p>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
