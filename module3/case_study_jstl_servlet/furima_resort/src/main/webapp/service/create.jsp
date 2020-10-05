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
                            <label for="id">Service ID:</label>
                            <input type="id" name="service_id" class="form-control" placeholder="Enter Service ID" id="id">
                        </div>

                        <div class="form-group">
                            <label for="name">Service Name:</label>
                            <input type="name" name="service_name" class="form-control" placeholder="Enter Service" id="name">
                        </div>

                        <div class="form-group">
                            <label for="ar">Area:</label>
                            <input type="service_area" name="service_area" class="form-control" placeholder="Enter Area" id="ar">
                        </div>

                        <div class="form-group">
                            <label for="cs">Cost:</label>
                            <input type="service_cost" name="service_cost" class="form-control" placeholder="Enter Cost" id="cs">
                        </div>

                        <div class="form-group">
                            <label for="pp">Max People:</label>
                            <input type="service_max_people" name="service_max_people" class="form-control" placeholder="Enter max people" id="pp">
                        </div>

                        <div class="form-group">
                            <label for="sd">Standar room:</label>
                            <input type="standard_room" name="standard_room" class="form-control" placeholder="Enter standard room" id="sd">
                        </div>

                        <div class="form-group">
                            <label for="dc">Description convenience:</label>
                            <input type="description_other_convenience" name="description_other_convenience" class="form-control" placeholder="Enter description convenience " id="dc">
                        </div>

                        <div class="form-group">
                            <label for="pa">Pool Area:</label>
                            <input type="pool_area" name="pool_area" class="form-control" placeholder="Enter pool area" id="pa">
                        </div>


                        <div class="form-group">
                            <label for="nf">Number of floors:</label>
                            <input type="number_of_floors" name="number_of_floors" class="form-control" placeholder="Enter number of floors" id="nf">
                        </div>



                        <%--  lay tu database--%>

                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Type of Service</label>
                            <select class="custom-select" name="service_type_id">
                                <c:forEach var="typeOfService" items="${typeOfServices}">
                                    <option value="${typeOfService.service_type_id}">${typeOfService.service_type_name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Type of rentr</label>
                            <select class="custom-select" name="rent_type_id">
                                <c:forEach var="typeOfRent" items="${typeOfRents}">
                                    <option value="${typeOfRent.rent_type_id}">${typeOfRent.rent_type_name}</option>
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
