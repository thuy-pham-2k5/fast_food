<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/headerAdmin.css">
</head>
<body>
<div class="app">
    <div class="header">
        <div class="menu-circle"></div>
        <div class="header-menu">
            <a class="menu-link is-active" href="#">Đồ ăn</a>
            <a class="menu-link" href="#">Đồ uống</a>
            <a class="menu-link" href="#">item</a>
            <a class="menu-link" href="#">item</a>
        </div>
        <div class="header">
            <div class="menu-circle">
                <div class="header-menu-icon">
                    <a class="menu-link" href="#"><img class="icon" src="/image/food-delivery.png"></a>
                    <a class="menu-link" href="#"><img class="icon" src="/image/user.png"></a>
                    <a class="menu-link" href="logout"><img class="icon" src="/image/exit.png"></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
