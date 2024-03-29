<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <style>
        .container-fluid {
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                        <a class="dropdown-item" href="service?action=create">Create</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/furama" method="post">
                <input class="form-control mr-sm-2" type="hidden" name="action" value="find">
                <input class="form-control mr-sm-2" type="search" name="name" placeholder="Search" aria-label="Search">
                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
            </form>
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
            <div class="col-10">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <table id="customer" class="table table-striped table-bordered" style="width:100%;
                            color: black;text-align: center;align-content: center;font-family: Arial;background: white">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Date of birth</th>
                                    <th>Gender</th>
                                    <th>Identify Card</th>
                                    <th>Phone Number</th>
                                    <th>Email</th>
                                    <th>Id type of customer</th>
                                    <th>Address</th>
                                    <th>Edit</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="contract" items="${contractList}">
                                    <tr>
                                        <td><c:out value="${contract.contract_id}"></c:out></td>
                                        <td><c:out value="${contract.contract_start_date}"></c:out></td>
                                        <td><c:out value="${contract.contract_end_date}"></c:out></td>
                                        <td><c:out value="${contract.contract_deposit}"></c:out></td>
                                        <td><c:out value="${contract.contract_total_money}"></c:out></td>
                                        <td><c:out value="${contract.employee_id}"></c:out></td>
                                        <td><c:out value="${contract.customer_id}"></c:out></td>
                                        <td><c:out value="${contract.service_id}"></c:out></td>

                                        <td>
                                            <a href="/contract?action=edit&id=${contract.contract_id}">Update</a>
                                        </td>
                                        <td>
                                            <a href="#" onclick="setContract('${contract_id.contract_id}')"
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
    </div>


    <%--                    delete modale--%>
    <div>

        <form action="/contract" method="get" id="formDelete">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" id="idContractHidden" name="idContractHidden" />
        </form>

        <!-- Modal -->

        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Do you want to delete this customer?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="submitFormDelete()">Delete</button>
                    </div>
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
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script>

    function setContract(id) {
        document.getElementById("idContractHidden").value = id;
    }

    function submitFormDelete() {
        let formDelete = document.getElementById("formDelete");
        formDelete.submit();
    }
</script>


</body>
</html>
