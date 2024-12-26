<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/25/2024
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/js/user/cart.js" defer></script>
</head>
<body>
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
