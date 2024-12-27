<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
    <script src="/js/user/bill.js" defer></script>
</head>
<style>
    body {
        background-color: #f9f9f9;
        margin: 0;
    }
    main {
        max-width: 1200px;
        margin: auto;
        background: white;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    p {
        margin: 5px 0;
    }

    label {
        display: block;
        margin-top: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    select {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        border: 1px solid #ddd; /* Added border for separation */
    }

    th {
        background-color: #f2f2f2;
    }
    td img {
        border-radius: 4px;
    }
    td.quantity,
    td.total,
    td.price,
    td.image{
        text-align: center;
    }
    th.total {
        -webkit-text-fill-color: red;
    }
    input[type="button"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 10px;
    }

    input[type="button"]:hover {
        background-color: #45a049;
    }

    span {
        font-weight: bold;
    }
    .buy {
      margin-left: 800px;
    }
</style>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div>
        <div>
            <c:if test="${not empty sessionScope.user}">
                <p>Tên người dùng: ${sessionScope.user.fullName}</p>
                <p>Số điện thoại: ${sessionScope.user.phone}</p>
                <label>
                    Địa chỉ: <input type="text" id="address" placeholder="Địa chỉ">
                </label>
                <p>
                    <span>Thanh toán: </span>
                    <select id="pay_status">
                        <option value="paid">Trả trước</option>
                        <option value="unpaid">Trả sau</option>
                    </select>
                </p>
            </c:if>
            <c:if test="${empty sessionScope.user}">
                <p>Không có thông tin người dùng trong session.</p>
            </c:if>
        </div>
        <div>
            <table>
                <tr>
                    <th>Hình ảnh</th>
                    <th>Tên món</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                </tr>
                <c:forEach var="food" items="${foods}">
                    <tr>
                        <td class="image"><img src="${food.imageUrl}" alt="Error" width="100px"/></td>
                        <td>${food.name}</td>
                        <td class="price">${food.price}</td>
                        <td class="quantity">${food.quantity}</td>
                        <td class="total">${food.price * food.quantity}</td>
                        <td style="display: none" class="foodId">${food.id}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="buy">
            <span>Tổng thanh toán: <span id="amount"></span></span>
            <input type="button" id="paymentButton" value="Xác nhận thanh toán">
        </div>
    </div>
</main>
</body>
</html>
