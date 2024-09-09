<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container-fluid">
        <a class="navbar-brand " href="/">
            <i class="fas fa-home"></i> User Management
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item"><a class="nav-link active" href="/">User List</a></li>

                <c:if test="${sessionScope.manager.getFullName().trim() == 'admin'}">
                    <li class="nav-item"><a class="nav-link active" href="/managerlist">Manager List</a></li>
                </c:if>

            </ul>

            <form class="form-inline">

                <div class="bg-light p-1 rounded">
                    <span class="fw-bold">Hi</span>
                    <span class="text-danger fw-bold">
                        <c:out value="${sessionScope.manager.getFullName()}"/>

                        <c:if test="${sessionScope.manager.getFullName().trim() != 'admin'}">
                            (<c:out value="${sessionScope.manager.getId()}"/>)
                        </c:if>

                    </span> |
                    <a href="/logout" class="text-decoration-none text-dark">Logout <i class="fas fa-sign-out-alt"
                            style="color: #000000;"></i></a>
                </div>

            </form>
        </div>
    </div>
</nav>