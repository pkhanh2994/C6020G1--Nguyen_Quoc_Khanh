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
        <a class="navbar-brand" href="furama?action=abc">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Employee <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Customer
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Create</a>
                        <a class="dropdown-item" href="furama?action=delete">Delete</a>
                        <a class="dropdown-item" href="furama?action=showInfor">Cutomer Information</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
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
                        <label for="id">Customer ID:</label>
                        <input type="id" name="id" class="form-control" placeholder="Enter Customer ID" id="id">
                    </div>

                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="name" name="name" class="form-control" placeholder="Enter Name" id="name">
                    </div>

                    <div class="form-group">
                        <label for="bd">Birthday:</label>
                        <input type="birthday" name="birthday" class="form-control" placeholder="Enter birthday" id="bd">
                    </div>

                    <div class="form-group">
                        <label for="gd">Gender:</label>
                        <input type="gender" name="gender" class="form-control" placeholder="Enter gender" id="gd">
                    </div>

                    <div class="form-group">
                        <label for="id_cd">ID Card:</label>
                        <input type="idCard" name="idcard" class="form-control" placeholder="Enter ID Card" id="id_cd">
                    </div>

                    <div class="form-group">
                        <label for="ph">Phone number:</label>
                        <input type="Phone" name="phone" class="form-control" placeholder="Enter phone number" id="ph">
                    </div>



                    <div class="form-group">
                        <label for="em">Email:</label>
                        <input type="email" name="email" class="form-control" placeholder="Enter email" id="em">
                    </div>

                       <%--  lay tu database--%>

                    <div class="form-group">
                        <input type="hidden" name="action" value="create" />
                        <label>Type of customer</label>
                        <select class="custom-select" name="typeOfCustomer">
                            <c:forEach var="typeOfCustomer" items="${typeOfCustomers}">
                                <option value="${typeOfCustomer.idTypeOfCustomer}">${typeOfCustomer.typeOfcustomer}</option>
                            </c:forEach>
                        </select>
                    </div>



                    <div class="form-group">
                        <label for="adr">Address:</label>
                        <input type="address" name="address" class="form-control" placeholder="Enter address" id="adr">
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

