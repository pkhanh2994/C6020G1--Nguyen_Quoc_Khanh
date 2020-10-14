<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <style>
        .container-fluid {
            background-image: url("https://bietthubientrieudo.com/wp-content/uploads/2015/11/EXT_Vinpearl-VungMe_Villa_Night_141107.jpg");
            background-repeat: no-repeat;
        }
    </style>

</head>
<body>

<div>
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="product?action=abc">
            <img src="https://png.pngtree.com/element_our/20190530/ourlarge/pngtree-520-couple-avatar-boy-avatar-little-dinosaur-cartoon-cute-image_1263411.jpg" width="50" height="60" alt=""
                 loading="lazy">
        </a>
    </nav>
</div>
<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-secondary ">
        <a class="navbar-brand" href="product?action=abc">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse" id="navbarSupportedContent3">
            <form class="form-inline my-2 my-lg-0" action="/product" method="post">
                <input class="form-control mr-sm-2" type="hidden" name="action" value="findPriceName">
                <input class="form-control mr-sm-2" type="search" name="price" placeholder="Price" aria-label="Search">
                <input class="form-control mr-sm-2" type="search" name="name" placeholder="Name" aria-label="Search">
                <button class="btn btn-success my-2 my-sm-0" type="submit" style="position: relative;left: 60px">Search Price and Name</button>
            </form>
        </div>



        <div class="col-sm-4" style="padding-left: 300px">
            <a href="/product?action=create" class="btn btn-success"><i
                    class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
        </div>

    </nav>
    <div class="container-fluid pt-5">
        <div class="row">
            <div class="col-2 px-0  vh-100 ">
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action list-group-item-primary">Primary item</a>
                    <a href="#" class="list-group-item list-group-item-action ">Primary item</a>
                    <a href="#" class="list-group-item list-group-item-action ">Primary item</a>
                    <a href="#" class="list-group-item list-group-item-action ">Primary item</a>
                    <a href="#" class="list-group-item list-group-item-action ">Primary item</a>
                    <a href="#" class="list-group-item list-group-item-action ">Primary item</a>
                    <a href="#" class="list-group-item list-group-item-action ">Primary item</a>

                </div>
            </div>
            <%--            Doan nay giong nhau nen cop lai phu hop voi them sua xoa--%>
            <div class="col-10">
                <div class="w-75 mx-auto">
                    <table id="product" class="table table-striped table-bordered" style="width:100%;
                            color: black;text-align: center;align-content: center;font-family: Arial;background: white">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Description</th>
                            <th>Color</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${productList}">
                        <tr>

                            <td><c:out value="${product.productID}"></c:out></td>
                            <td><c:out value="${product.productName}"></c:out></td>
                            <td><c:out value="${product.price}"></c:out></td>
                            <td><c:out value="${product.quantity}"></c:out></td>


                            <td>
                                <c:forEach var="category" items="${categoryList}">
                                <c:if test="${category.getCategoryID().equals(product.getCategoryID())}">
                                    <c:out value="${category.typeOfProduct}"></c:out>
                                </c:if>
                                </c:forEach>
                            </td>

                            <td><c:out value="${product.description}"></c:out></td>

                            <td>
                                <c:forEach var="color" items="${colorList}">
                                    <c:if test="${color.getColorID().equals(product.getColorID())}">
                                        <c:out value="${color.colorName}"></c:out>
                                    </c:if>
                                </c:forEach>
                            </td>


                            <td>
                                <a href="/product?action=edit&id=${product.productID}">Update</a>
                            </td>

                            <td>
                                <a href="#" onclick="setProduct('${product.productID}')"
                                   data-toggle="modal" data-target="#deleteModal">Delete</a>
                            </td>

                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


    <%--                    delete modale--%>
<div>

    <form action="/product" method="get" id="formDelete">
        <input type="hidden" name="action" value="delete"/>
        <input type="hidden" id="idProductHidden" name="idProductHidden"/>
    </form>

    <!-- Modal -->

    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete product</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this product?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="submitFormDelete()">Delete</button>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery-3.5.1.min.js"></script>

<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>

<script src="js/bootstrap.bundle.min.js"></script>


<script>
    $(document).ready(function () {
        $('#product').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

<script>

    function setProduct(id) {
        document.getElementById("idProductHidden" +
            "").value = id;
    }

    function submitFormDelete() {
        let formDelete = document.getElementById("formDelete");
        formDelete.submit();
    }
</script>

</body>
</html>