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
</head>
<body>
<div>
    <c:forEach var="food" items="${foods}">
        <jsp:include page="foodCard.jsp">
            <jsp:param name="foodId" value="${food.id}"/>
            <jsp:param name="foodName" value="${food.name}" />
            <jsp:param name="foodPrice" value="${food.price}" />
            <jsp:param name="foodImage" value="${food.imageUrl}" />
        </jsp:include>
    </c:forEach>
</div>
</body>

</html>

