<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="container">
    <form action="/authenticate?action=signup" method="post">
        <p>Đăng ký</p>
        <input type="text" name="fullName" placeholder="Họ tên"><br>
        <input type="number" name="phone" placeholder="Số điện thoại"><br>
        <input type="password" name="password" placeholder="Mật khẩu"><br>
        <input type="password" name="confirmPassword" placeholder="Xác nhận mật khẩu"><br>
        <input type="submit" value="Đăng nhập"><br>
        <label>Bạn đã có tài khoản? </label><a href="/user?action=login">Đăng nhập ngay</a>
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
