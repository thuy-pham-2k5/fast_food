<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>[Xmas]Giỏ hàng</title>
    <script src="/js/user/cart.js" defer></script>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
    }

    main {
        max-width: 1200px;
        margin: 10px auto;
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }


    h1 {
        text-align: center;
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: center;
        vertical-align: middle;
    }

    #amount {
        -webkit-text-fill-color: red;
    }

    th {
        background-color: #3d8f30;
        -webkit-text-fill-color: #ffffff;
    }

    td img {
        border-radius: 4px;
    }

    .checkbox {
        cursor: pointer;
        width: 15px;
        height: 15px;
    }

    .quantity {
        width: 60px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin: 0;
        padding: 10px 15px;
    }

    button:hover {
        background-color: red;
    }

    #checkbox {
        cursor: pointer;
        width: 15px;
        height: 15px;
    }

    span {
        font-weight: bold;
    }

    #orderButton {
        margin-top: 10px;
        height: 20px;
    }

    td.checkbox,
    td.image,
    td.price,
    td.quantity,
    td.total {
        text-align: center;
        align-content: center;
    }

    td.name {
        text-align: left;
    }
    .checkbox-total {
        display: flex;
    }

    .checkbox-total div {
        width: 50%;
    }

    .orderButton {
        display: flex;
        justify-content: flex-end;
    }
    #orderButton {
        height: 40px;
        width: 100px;
        border-radius: 5px;
        background-color: red;
        -webkit-text-fill-color: #ffffff;
        margin-right: 20px;
        border-color: red;
    }
    #orderButton:hover {
        background-color: #BD0916; /* Change to a darker shade on hover */
        border-color: #BD0916; /* Change border color to match */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
</style>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div class="div-parent">
        <c:if test="${not empty foods}">
            <div>
                <table>
                    <tr>
                        <th>Chọn</th>
                        <th>Hình ảnh</th>
                        <th>Tên món</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                        <th>Xóa</th>
                    </tr>
                    <c:forEach items="${foods}" var="food">
                        <tr>
                            <td><input type="checkbox" class="checkbox"></td>
                            <td class="image"><img src="${food.getImageUrl()}" alt="Error" width="100px"></td>
                            <td class="name">${food.getName()}</td>
                            <td class="price">${food.getPrice()}</td>
                            <td><input type="number" max="${food.getQuantity()}" value="1" class="quantity"></td>
                            <td class="total">${food.getPrice()}</td>
                            <td>
                                <a href="/cart-user?action=delete&id=${food.id}">
                                    <button>Xóa</button>
                                </a>
                            </td>
                            <td class="foodId" style="display: none;">${food.id}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="checkbox-total">
                <div>
                    <label>
                        <input type="checkbox" id="checkbox">
                        <span>Tất cả</span>
                    </label>
                    <span>Tổng thanh toán: <span id="amount"></span></span>
                </div>
                <div class="orderButton">
                    <input type="button"  id="orderButton" value="Đặt món">
                </div>
            </div>
        </c:if>
        <c:if test="${empty foods}">
            <p>Bạn chưa thêm món ăn nào hết</p>
            <p>Lướt FastFood tận hưởng các món ăn siêu hấp dẫn mùa giáng sinh ngay nha!</p>
            <a href="/home-user">
                <button>Đặt món ngay</button>
            </a>
        </c:if>
    </div>
</main>
</body>
</html>
