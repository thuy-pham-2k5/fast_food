<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng nhập tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/authenticate/login.css">
</head>
<body>

<div class="container">
    <form >
        <p>Chào mừng!</p>
        <input type="number" placeholder="Số điện thoại"><br>
        <input type="password" placeholder="Mật khẩu"><br>
        <input type="button" value="Đăng nhập"><br>
        <label>Bạn chưa có tài khoản? </label><a href="#">Đăng ký ngay</a>
    </form>

    <div class="drops">
        <div class="drop drop-1"></div>
        <div class="drop drop-2"></div>
        <div class="drop drop-3"></div>
        <div class="drop drop-4"></div>
        <div class="drop drop-5"></div>
    </div>
</div>
</body>
</html>
