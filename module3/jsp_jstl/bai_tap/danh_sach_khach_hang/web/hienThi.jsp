
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hien Thi</title>
    <style>
td, tr {
    text-align: center;
}
    </style>
</head>
<body>
    <h2 style="text-align: center">Danh Sách Khách Hàng</h2>
    <table width="800px"style="position: relative;left: 350px">

    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>

    <c:forEach var="khachhang" items="${danhSachKhachHang}">
        <tr>
            <td colspan="4"><hr></td>
        </tr>
        <tr >
            <td>${khachhang.ten}</td>
            <td>${khachhang.ngaySinh}</td>
            <td>${khachhang.diaChi}</td>
            <td><img src="${khachhang.anh}" style="width: 70px;height: 70px"></td>
        </tr>

    </c:forEach>
    </table>

</body>
</html>
