<!-- Toastr CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Toastr JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty sessionScope.toastMessage}">
  <script>
    document.addEventListener('DOMContentLoaded', function () {
      toastr.options = {
        closeButton: true,
        progressBar: true,
        timeOut: 3000,
        extendedTimeOut: 2000,
        positionClass: 'toast-top-right',
        preventDuplicates: true,
        showDuration: 300,
        hideDuration: 300
      };
      toastr.${sessionScope.toastType}("<c:out value="${sessionScope.toastMessage}"/>");
    });
  </script>
</c:if>
<c:remove var="toastMessage" scope="session"/>

