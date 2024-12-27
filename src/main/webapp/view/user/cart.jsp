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

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
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
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #45a049;
    }

    #checkbox {
        cursor: pointer;
    }

    span {
        font-weight: bold;
    }

    #orderButton {
        margin-top: 10px;
        height: 20px;
    }
</style>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div>
        <c:if test="${foods!=null}">
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
                            <td><img src="${food.getImageUrl()}" alt="Error" width="100px"></td>
                            <td>${food.getName()}</td>
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
            <div>
                <label>
                    <input type="checkbox" id="checkbox">
                    <span>Tất cả</span>
                </label>
                <span>Tổng thanh toán: <span id="amount"></span></span>
                <input type="button" id="orderButton" value="Đặt món">
            </div>
        </c:if>
        <c:if test="${foods==null}">
            <p>Bạn chưa thêm món ăn nào hết</p>
            <p>Lướt FastFood tận hưởng các món ăn siêu hấp dẫn mùa giáng sinh ngay nha!</p>
            <a href="/cart-user?action"><button>Đặt món ngay</button></a>
        </c:if>
    </div>
</main>
</body>
</html>
