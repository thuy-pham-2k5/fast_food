<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/27/2024
  Time: 4:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
    <script src="/js/user/bill.js" defer></script>
</head>
<body>
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
                        <td><img src="${food.imageUrl}" alt="Error" width="100px"/></td>
                        <td>${food.name}</td>
                        <td>${food.price}</td>
                        <td class="quantity">${food.quantity}</td>
                        <td class="total">${food.price * food.quantity}</td>
                        <td style="display: none" class="foodId">${food.id}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <span>Tổng thanh toán: <span id="amount"></span></span>
            <input type="button" id="paymentButton" value="Xác nhận thanh toán">
        </div>
    </div>
</main>
</body>
</html>
