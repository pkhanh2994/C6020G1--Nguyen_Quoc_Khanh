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
            <div class="col-9">
                <p style="color: red">${message}</p>
                <div align="center">
                    <form method="post">
                        <table  cellpadding="5" style="color: white;border: #005cbf"  >
                            <c:if test="${product != null}">
                                <input type="hidden" name="id" value="<c:out value='${product.productID}' />"/>
                            </c:if>
                            <tr>
                                <th>Product Name:</th>
                                <td>
                                    <input type="text" name="name" size="45"
                                           value="<c:out value='${product.productName}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Price:</th>
                                <td>
                                    <input type="text" name="price" size="45"
                                           value="<c:out value='${product.price}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Quantity</th>
                                <td>
                                    <input type="text" name="quantity" size="45"
                                           value="<c:out value='${product.quantity}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>color</th>
                                <td>
                                    <input type="text" name="color" size="15"
                                           value="<c:out value='${product.color}' />"
                                    />
                                </td>
                            </tr>
                            <tr>
                                <th>Category</th>
                                <td>
                                    <input type="hidden" name="action" value="edit" />
                                    <select class="custom-select" name="category">
                                        <c:forEach var="category" items="${categoryList}">
                                            <c:choose>
                                                <c:when test="${category.getCategoryID().equals(product.getCategoryID())}">
                                                    <option value="<c:out value='${category.categoryID}'/>" selected><c:out value="${category.typeOfProduct}"></c:out></option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="<c:out value='${category.categoryID}'/>"><c:out value="${category.typeOfProduct}"></c:out></option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
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
