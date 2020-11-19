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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Employee
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <a class="dropdown-item" href="employee?action=create">Create</a>
                        <a class="dropdown-item" href="employee?action=showInfor">Employee Information</a>
                    </div>
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                        <a class="dropdown-item" href="service?action=create">Create</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Contract
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                        <a class="dropdown-item" href="contract?action=create">Create</a>
                    </div>
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
                            <label for="id">Contact ID:</label>
                            <input type="id" name="id" class="form-control" placeholder="Enter contract ID" id="id">
                        </div>

                        <div class="form-group">
                            <label for="ctd">Start Day:</label>
                            <input type="date" name="contract_start_date" class="form-control" placeholder="Enter start day" id="ctd">
                        </div>

                        <div class="form-group">
                            <label for="ed">End day:</label>
                            <input type="date" name="contract_end_date" class="form-control" placeholder="Enter end day" id="ed">
                        </div>

                        <div class="form-group">
                            <label for="dps">Deposit:</label>
                            <input type="contract_deposit" name="contract_deposit" class="form-control" placeholder="Enter deposit" id="dps">
                        </div>

                        <div class="form-group">
                            <label for="tm">Total money:</label>
                            <input type="contract_total_money" name="contract_total_money" class="form-control" placeholder="Enter total money" id="tm">
                        </div>





                        <%--  lay tu database--%>

                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Employee name</label>
                            <select class="custom-select" name="employee">
                                <c:forEach var="employee" items="${employeeList}">
                                    <option value="${employee.employee_id}">${employee.employee_name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Customer name</label>
                            <select class="custom-select" name="customer">
                                <c:forEach var="customer" items="${customerList}">
                                    <option value="${customer.customer_id}">${customer.customer_name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Service name</label>
                            <select class="custom-select" name="service">
                                <c:forEach var="service" items="${serviceList}">
                                    <option value="${service.service_id}">${service.service_name}</option>
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

