<%@ page import="com.example.fastfood.model.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.fastfood.service.FoodService" %>
<%@ page import="com.example.fastfood.service.FoodServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/home-user.css">
    <script src="/js/user/home.js" defer></script>
</head>
<body>
<div id="customAlert"
     style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; color: black; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); text-align: center; z-index: 1000;">
    <p>Thêm vào giỏ thành công!</p>
</div>
<div id="overlay" style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.5); z-index: 999;"></div>
<div>
    <c:forEach var="food" items="${foods}">
        <jsp:include page="foodCard.jsp">
            <jsp:param name="foodId" value="${food.id}"/>
            <jsp:param name="foodName" value="${food.name}"/>
            <jsp:param name="foodPrice" value="${food.price}"/>
            <jsp:param name="foodImage" value="${food.imageUrl}"/>
        </jsp:include>
    </c:forEach>
</div>

</body>
</html>

