<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />

    <style>
        .container-fluid{
            background-image: url("https://bietthubientrieudo.com/wp-content/uploads/2015/11/EXT_Vinpearl-VungMe_Villa_Night_141107.jpg");
        }
        label{
            color: orangered;
        }
    </style>

</head>
<body>
<!-- Just an image -->

<div>
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="furama?action=abc">
            <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" width="50" height="60" alt=""
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

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="container-fluid pt-5">
        <div class="row">
            <div class="col-3 px-0  vh-100 ">
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
            <%--            doan nay thay doi phu hop voi yeu cau them--%>
            <div class="col-9">
                <div class="w-75 rounded p-1 mx-auto">

                    <form method="post">

                        <div class="form-group">
                            <label for="n">Product Name:</label>
                            <input type="name" name="name" class="form-control" placeholder="Enter product name" id="n">
                        </div>

                        <div class="form-group">
                            <label for="pr">Product price:</label>
                            <input type="price" name="price" class="form-control" placeholder="Enter product price" id="pr">
                        </div>

                        <div class="form-group">
                            <label for="qt">quantity:</label>
                            <input type="quantity" name="quantity" class="form-control" placeholder="Enter quantity" id="qt">
                        </div>

                        <div class="form-group">
                            <label for="cl">Color:</label>
                            <input type="colorr" name="color" class="form-control" placeholder="Enter color" id="cl">
                        </div>


                        <%--  lay tu database--%>

                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Category</label>
                            <select class="custom-select" name="category">
                                <c:forEach var="category" items="${categoryList}">
                                    <option value="${category.categoryID}">${category.typeOfProduct}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <button type="submit" class="btn btn-primary">Submit</button><span>
                    <p style="color: red">${message}</p></span>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
