<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
    <%@include file="component/allcss.jsp"%>
</head>
<body>
<header>
    <%@include file="component/navbar.jsp"%>
</header>
    <%@include file="component/toastMessage.jsp"%>
<div id="toastContainer"></div>
    <div class="container my-4 text-center">
        <h1 class="text-center">List of Users</h1>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/add" class="btn btn-success m-2">Add
                New User</a>
        </div>

        <!-- User List -->
        <table class="table table-striped table-bordered" id="tableId" border="1" cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Mobile Phone</th>
                <th>Active</th>
                <th>Date Created</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${requestScope.listUser}">
                <tr>
                    <td><c:out value="${user.getUserID()}"/></td>
                    <td><c:out value="${user.getUserName()}"/></td>
                    <td><c:out value="${user.getEmail()}"/></td>
                    <td><c:out value="${user.getMobilePhone()}"/></td>

                    <c:choose>
                        <c:when test="${user.getActive() == 1}">
                            <td><i class="fas fa-check-circle fa-lg" style="color: #2ed30d;"></i></td>
                        </c:when>
                        <c:otherwise>
                            <td><i class="fas fa-times-circle fa-lg" style="color: #f50000;"></i></td>
                        </c:otherwise>
                    </c:choose>

                    <td><c:out value="${user.getDateCreated()}"/></td>
                    <td>
                        <a href="/update_user?id=${user.userID}" class="btn btn-warning">
                            <i class="fas fa-edit"></i> Edit
                        </a>
                        <a href="/delete_user?id=${user.userID}" class="btn btn-danger deleteButton">
                            <i class="fas fa-trash"></i> Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <!-- For displaying Previous link except for the 1st page -->
                <c:if test="${requestScope.currentPage != 1}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${requestScope.currentPage - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <!-- For displaying Page numbers. The when condition does not display a link for the current page -->
                <c:forEach begin="1" end="${requestScope.noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${requestScope.currentPage eq i}">
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="#">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="?page=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <!-- For displaying Next link -->
                <c:if test="${currentPage lt noOfPages}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</body>
</html>

