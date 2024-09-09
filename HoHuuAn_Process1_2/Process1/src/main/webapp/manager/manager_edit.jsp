<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <%@include file="/component/allcss.jsp"%>
</head>
<body>
<header>
    <%@include file="/component/navbar.jsp"%>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="update_manager" method="post">
                <caption>
                    <h2>Edit Manager</h2>
                </caption>

                <fieldset class="form-group">
                    <label>Manager Name</label> <input type="text"
                                                    value="<c:out value="${requestScope.manager.getFullName()}"/>"
                                                    class="form-control"
                                                    name="fullName"
                                                    required="required">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>Manager Email</label> <input type="text"
                                                     value="<c:out value="${requestScope.manager.getEmail()}"/>"
                                                     class="form-control"
                                                     name="email">
                </fieldset>
                <br>
                <fieldset class="form-group">
                    <label>Manager Password</label> <input type="text"
                                                     value="<c:out value="${requestScope.manager.getPassword()}"/>"
                                                     class="form-control"
                                                     name="password">
                </fieldset>
                <br>
                <button type="submit" class="btn btn-success">Save</button>

            </form>
        </div>
    </div>
</div>
</body>
</html>
