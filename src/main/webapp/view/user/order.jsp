<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/27/2024
  Time: 6:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đơn hàng của bạn</title>
</head>
<body>
<main>
    <div>
        <button>Chờ giao</button>
        <button>Đang giao</button>
        <button>Đã giao</button>
        <button>Hủy đơn</button>
    </div>
    <div>
        <table>
            <tr>
                <th>#</th>
                <th>Thời gian đặt</th>
                <th>Tổng món ăn</th>
                <th>Tổng thanh toán</th>
                <th>Trạng thái thanh toán</th>
                <th>Trạng thái đơn</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <td>${order.idOrder}</td>
                <td>${order.orderTime}</td>
                <td>${order.totalFood}</td>
                <td>${order.amount}</td>
                <td>${order.orderStatus}</td>
            </c:forEach>
        </table>

    </div>
</main>
</body>
</html>
