<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Create</title>
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
                        <a class="dropdown-item" href="furama?action=create">Create</a>
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
                        <a class="dropdown-item" href="contract?action=showInfor">Show information</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Contract Details
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                        <a class="dropdown-item" href="contractDetails?action=create">Create</a>
                        <a class="dropdown-item" href="contractDetails?action=showInfor">Show information</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Customer Using Service
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                        <a class="dropdown-item" href="userService?action=showInfor">Show information</a>
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
                            <label for="id">Employee ID:</label>
                            <input type="id" name="employee_id" class="form-control" placeholder="Enter Employee ID" id="id">
                        </div>

                        <div class="form-group">
                            <label for="name">Employee Name:</label>
                            <input type="name" name="employee_name" class="form-control" placeholder="Enter employee name" id="name">
                        </div>

                        <div class="form-group">
                            <label for="ar">Birthday:</label>
                            <input type="employee_birthday" name="employee_birthday" class="form-control" placeholder="Enter employee birthday" id="ar">
                        </div>

                        <div class="form-group">
                            <label for="cs">ID Card:</label>
                            <input type="employee_id_card" name="employee_id_card" class="form-control" placeholder="Enter ID card" id="cs">
                        </div>

                        <div class="form-group">
                            <label for="pp">Salary</label>
                            <input type="employee_salary" name="employee_salary" class="form-control" placeholder="Enter Salary" id="pp">
                        </div>

                        <div class="form-group">
                            <label for="sd">Phone number:</label>
                            <input type="employee_phone" name="employee_phone" class="form-control" placeholder="Enter phone number" id="sd">
                        </div>

                        <div class="form-group">
                            <label for="dc">Email:</label>
                            <input type="employee_email" name="employee_email" class="form-control" placeholder="Enter email " id="dc">
                        </div>

                        <div class="form-group">
                            <label for="pa">Address:</label>
                            <input type="employee_address" name="employee_address" class="form-control" placeholder="Enter address" id="pa">
                        </div>


                        <div class="form-group">
                            <label for="nf">User Name:</label>
                            <input type="user_name" name="user_name" class="form-control" placeholder="Enter user name" id="nf">
                        </div>



                        <%--  lay tu database--%>

                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Position</label>
                            <select class="custom-select" name="position_id">
                                <c:forEach var="position" items="${positions}">
                                    <option value="${position.position_id}">${position.position_name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Education degrees</label>
                            <select class="custom-select" name="educationDegrees">
                                <c:forEach var="educationDegree" items="${educationDegrees}">
                                    <option value="${educationDegree.education_degree_id}">${educationDegree.education_degree_name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group">
                            <input type="hidden" name="action" value="create" />
                            <label>Division</label>
                            <select class="custom-select" name="divisions">
                                <c:forEach var="division" items="${divisions}">
                                    <option value="${division.division_id}">${division.division_name}</option>
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
