<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../error.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Danh sách sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body style="background-color: #f8f8f8">

<div class="container-fluid p-5">
    <div class="row mb-5">
        <div class="col-md-6">
            <h3>Product Management</h3>
        </div>
        <div class="col-md-6 text-right">
            Xin chào <span class="text-danger"><c:out value="${sessionScope.user.email}"/></span> | <a href="/logout">Logout</a>
        </div>
    </div>
    <div class="row rounded border p-3">
        <div class="col-md-4">
            <h4 class="text-success">Thêm sản phẩm mới</h4>
            <form action="products" class="mt-3 form" method="post">
                <div class="form-group">
                    <label for="product-name">Tên sản phẩm</label>
                    <input  class="form-control" type="text" placeholder="Nhập tên sản phẩm" id="product-name" name="name"
                            value="<c:out value="${requestScope.name}"/>">
                </div>
                <div class="form-group">
                    <label for="price">Giá sản phẩm</label>
                    <input class="form-control" type="number" placeholder="Nhập giá bán" id="price" name="price"
                           value="<c:out value="${requestScope.price}"/>">
                </div>
                <div class="form-group">
                    <button class="btn btn-success mr-2" type="submit">Thêm sản phẩm</button>
                </div>
                <div style="display: none" id="flash-alert" class="form-group ">
                    <div class="alert alert-danger"></div>
                </div>
            </form>
        </div>
        <div class="col-md-8">
            <h4 class="text-success">Danh sách sản phẩm</h4>
            <p>Chọn một sản phẩm cụ thể để xem chi tiết</p>
            <table class="table table-striped" id="table">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody id="table-body">
                <c:forEach var="product" items="${requestScope.products}" varStatus="loop">
                    <tr id = "<c:out value="${product.getId()}"/>">
                        <td>${loop.index + 1}</td>
                        <td><a href="#"><c:out value="${product.getName()}"/></a></td>
                        <td><c:out value="${product.getPrice()}"/></td>
                        <td>
                            <a href="#">Chỉnh sửa</a> |
                            <a href="#" id="delete-btn"
                               onclick="idDelete( '<c:out value="${product.getName()}"/>', <c:out value="${product.getId()}"/>)"
                            >Xóa</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal" id="confirmDelete">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Remove product</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                Are you sure you want to delete <strong class="product-name">product</strong>?
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn-confirm-delete" onclick="confirmDelete(event)">
                    Delete
                </button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });

    //delete
    function idDelete(event, name, id) {
        event.preventDefault();
        $('#confirmDelete .product-name').html(name);
        $('#confirmDelete .btn-confirm-delete').attr('data-id', id);

        $('#confirmDelete').modal('show');
    }
    function confirmDelete(event) {
        if ($(event.target).is('.btn-confirm-delete')) {
            let id = event.target.dataset.id;

            $('#confirmDelete').modal('hide');
            deleteProduct(id);
        }
    }
    function deleteProduct(id) {
        fetch('http://localhost:8080/products?id=' + encodeURIComponent(id), {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Request failed with status: ' + response.status);
                }
            })
            .then(data => {
                if (data.code === 0) {
                    var element = document.getElementById(id);
                    if (element) {
                        element.remove();
                    }
                } else {
                    console.log(data.message);
                }
            })
            .catch(error => {
                console.log('Request failed:', error);
            });
    }

    //add
    const tableBody = document.getElementById('table-body');
    var form = document.querySelector('.form');
    form.addEventListener('submit', function(event) {
        event.preventDefault();

        var productName = document.getElementById('product-name').value;
        var productPrice = document.getElementById('price').value;

        if(productName === "" || productPrice === ""){
            $('#flash-alert').attr('style', 'display: block');
            $('.alert-danger').html("Please input name and price");
        }
        fetch('http://localhost:8080/products', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'name=' + encodeURIComponent(productName) + '&price=' + encodeURIComponent(productPrice)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Request failed with status: ' + response.status);
                }
            })
            .then(response => {
                if (response.code === 0) {
                    let tr = document.createElement('tr');
                    let id = document.createElement('td');
                    let name = document.createElement('td');
                    let price = document.createElement('td');
                    let action = document.createElement('td');

                    tr.setAttribute('id', response.id);
                    id.innerHTML = tableBody.rows.length + 1;
                    name.innerHTML = '<a href="#">' + response.name + '</a>';
                    price.innerHTML = response.price;
                    let id_response = response.id;
                    let name_response = response.name;
                    action.innerHTML = `<a href="#"> Chỉnh sửa</a> | <a href="#"  id="delete-btn" onclick= "idDelete('`+ name_response + `',` + id_response + `)">Xóa</a>`

                    tr.appendChild(id)
                    tr.appendChild(name)
                    tr.appendChild(price)
                    tr.appendChild(action)

                    tableBody.appendChild(tr);

                    document.getElementById('product-name').value = "";
                    document.getElementById('price').value = "";

                    $('#flash-alert').attr('style', 'display: none');
                }else {
                    $('#flash-alert').attr('style', 'display: block');
                    $('.alert-danger').html(response.message);
                }
            })
            .catch(error => {
                console.log('Request failed:', error);
            });
    });
</script>
</body>
</html>