<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/27/2024
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
  <div>
    <table>
        <tr>
            <th>Hình ảnh</th>
            <th>Tên món</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th>Trạng thái</th>
        </tr>
        <c:forEach var="food" items="${foods}">
            <tr>
                <td><img src="${food.imageUrl}" alt="Error" width="100px"/></td>
                <td>${food.name}</td>
                <td>${food.quantity}</td>
                <td>${food.price * food.quantity}</td>
                <td>${food.orderStatus}</td>
            </tr>
        </c:forEach>
    </table>
  </div>
</main>
</body>
</html>
