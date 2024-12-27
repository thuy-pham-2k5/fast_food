<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đơn hàng của bạn</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
    }

    main {
        max-width: 1200px;
        margin: auto;
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        color: #333;
    }

    button {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
        margin: 5px;
    }

    button:hover {
        background-color: #45a049;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #f5f5f5;
    }

    td {
        color: #555;
    }
</style>
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
                <th></th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.idOrder}</td>
                    <td>${order.orderTime}</td>
                    <td>${order.totalFood}</td>
                    <td>${order.amount}</td>
                    <td>${order.paymentStatus}</td>
                    <td>${order.orderStatus}</td>
                    <td><a href="/order-user?action=inform&idOrder=${order.idOrder}">
                        <button>Chi tiết đơn</button>
                    </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>
