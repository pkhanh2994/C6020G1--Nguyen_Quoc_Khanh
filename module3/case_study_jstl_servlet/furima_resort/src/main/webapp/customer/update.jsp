<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
    <style>
        .container-fluid{
            background-image: url("https://bietthubientrieudo.com/wp-content/uploads/2015/11/EXT_Vinpearl-VungMe_Villa_Night_141107.jpg");
        }
    </style>

</head>
<body>

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
                        <a class="dropdown-item" href="furama?action=create">Create</a>
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
            <div class="col-9">
                <p style="color: red">${message}</p>
                <div align="center">
                    <form method="post">
                        <table  cellpadding="5" style="color: white;border: #005cbf"  >
                            <c:if test="${customer != null}">
                                <input type="hidden" name="id" value="<c:out value='${customer.customer_id}' />"/>
                            </c:if>
                            <tr>
                                <th>User Name:</th>
                                <td>
                                    <input type="text" name="name" size="45"
                                           value="<c:out value='${customer.customer_name}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>User birthday:</th>
                                <td>
                                    <input type="date" name="birthday" size="45"
                                           value="<c:out value='${customer.customer_birthday}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Gender</th>
                                <td>
                                    <input type="text" name="gender" size="15"
                                           value="<c:out value='${customer.customer_gender}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Idennity Card</th>
                                <td>
                                    <input type="text" name="idCard" size="15"
                                           value="<c:out value='${customer.customer_id_card}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Phone</th>
                                <td>
                                    <input type="text" name="phone" size="15"
                                           value="<c:out value='${customer.customer_phone}' />"
                                    />
                                </td>
                            </tr>

                            <tr>
                                <th>Type of customer</th>
                                <td>
                                    <input type="hidden" name="action" value="edit" />
                                    <select class="custom-select" name="typeOfCustomer">
                                        <c:forEach var="typeOfCustomer" items="${typeOfCustomers}">
                                            <option value="${typeOfCustomer.idTypeOfCustomer}">${typeOfCustomer.typeOfcustomer}</option>
                                        </c:forEach>
                                    </select>
                                </td>

                            </tr>

                            <tr>
                                <th>Address</th>
                                <td>
                                    <input type="text" name="address" size="15"
                                           value="<c:out value='${customer.customer_address}' />"
                                    />
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" value="Save"/>
                                </td>
                            </tr>
                        </table>
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