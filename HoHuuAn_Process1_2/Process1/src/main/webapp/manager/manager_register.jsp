<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css    ">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        p.item {
            padding: 16px;
            text-align: center;
            border-radius: 8px;
            color: white;
            background-color: green;
        }
    </style>
</head>

<body class="bg-secondary">

    <h3 class="text-center my-5 text-light">Manager Registration</h3>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-5">
                <div class="border p-3 rounded bg-light">
                    <form method="post" action="register">


                        <div class="form-group">
                            <label for="id">ID</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        <i class="fas fa-fingerprint"></i>
                                    </span>
                                </div>
                                <input  id="id" type="text" class="form-control"
                                        placeholder="ID Manager"
                                        name="id"
                                        value="<c:out value="${requestScope.id}"/>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name">Fullname</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        <i class="fas fa-user"></i>
                                    </span>
                                </div>
                                <input id="name" type="text" class="form-control"
                                        placeholder="Your Name"
                                        name="fullname"
                                        value="<c:out value="${requestScope.fullname}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        <i class="fas fa-user"></i>
                                    </span>
                                </div>
                                <input  id="email" type="text" class="form-control"
                                        placeholder="Email"
                                        name="email"
                                        value="<c:out value="${requestScope.email}"/>">
                            </div>

                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        <i class="fas fa-lock"></i>
                                    </span>
                                </div>
                                <input id="password" type="password" class="form-control"
                                    placeholder="Password" 
                                    name="password"
                                    value="<c:out value="${requestScope.password}"/>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password-confirm">Confirm Password</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">
                                        <i class="fas fa-lock"></i>
                                    </span>
                                </div>
                                <input id="password-confirm" type="password" class="form-control"
                                    placeholder="Password" 
                                    name="passwordConfirm"
                                    value="<c:out value="${requestScope.passwordConfirm}"/>">
                            </div>
                        </div>

                        <c:if test="${not empty sessionScope.error}">
                            <div class="form-group">
                                <div class="alert alert-danger">
                                    <button type="button" class="close"
                                        data-dismiss="alert">&times;</button>
                                    <c:out value="${sessionScope.error}" />
                                </div>
                            </div>
                        </c:if>

                        <c:remove var="error" scope="session" />
                        <div class="form-group">
                            <button class="btn btn-success px-5" type="submit">Register</button>
                        </div>
                        <div class="form-group">
                            <p>Already have an account? <a href="/login">Login now!</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>