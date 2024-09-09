<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <%@include file="component/allcss.jsp"%>
</head>
<body>

<header>
    <%@include file="component/navbar.jsp"%>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="add" method="post">
                <caption>
                    <h2>Add User</h2>
                </caption>
                <fieldset class="form-group">
                    <label>User ID</label> <input   type="text" class="form-control"
                                                    name="id"
                                                    value="<c:out value="${requestScope.user.getUserID()}"/>">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>User Name</label> <input type="text" class="form-control"
                                                    name="name"
                                                    value="<c:out value="${requestScope.user.getUserName()}"/>">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>User Email</label> <input type="text" class="form-control"
                                                     name="email"
                                                     value="<c:out value="${requestScope.user.getEmail()}"/>">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>User Phone</label> <input type="text" class="form-control"
                                                       name="phone"
                                                       value="<c:out value="${requestScope.user.getMobilePhone()}"/>">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>Activated</label>
                    <div class="form-check">
                        <input type="radio"
                               id="activatedCheckbox"
                               name="activated"
                               value="true"
                               class="form-check-input"
                               <c:if test="${requestScope.user.getActive()  == 1}">checked</c:if>>
                        <label class="form-check-label" for="activatedCheckbox">Activated</label>
                    </div>
                    <div class="form-check">
                        <input type="radio"
                               id="inactivatedCheckbox"
                               name="activated"
                               value="false"
                               class="form-check-input"
                               <c:if test="${requestScope.user.getActive() == 0}">checked</c:if>>
                        <label class="form-check-label" for="inactivatedCheckbox">Inactivated</label>
                    </div>
                </fieldset>
                <br>
                <c:if test="${not empty sessionScope.error}">
                    <div class="alert alert-danger"><c:out value="${sessionScope.error}"/></div>
                </c:if>

                <c:remove var="error" scope="session"/>
                <br>
                <button type="submit" class="btn btn-success">Submit</button>
                <br>
            </form>
        </div>
    </div>
</div>
</body>
</html>