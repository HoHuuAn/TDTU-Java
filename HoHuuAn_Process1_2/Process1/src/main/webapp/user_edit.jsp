<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
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
            <form action="update_user" method="post">
                <caption>
                    <h2>Edit User</h2>
                </caption>

                <fieldset class="form-group">
                    <label>User Name</label> <input type="text"
                                                    value="<c:out value="${requestScope.user.getUserName()}"/>"
                                                    class="form-control"
                                                    name="name"
                                                    required="required">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>User Email</label> <input type="text"
                                                     value="<c:out value="${requestScope.user.getEmail()}"/>"
                                                     class="form-control"
                                                     name="email">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>User Phone</label> <input type="text"
                                                     value="<c:out value="${requestScope.user.getMobilePhone()}"/>"
                                                     class="form-control"
                                                     name="phone">
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
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
