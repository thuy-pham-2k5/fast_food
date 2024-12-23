<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <script src="/js/authenticate/register.js" defer></script>
</head>
<body>

<div class="container">
    <form action="/authenticate?action=signup" method="post" onsubmit="return validateForm()">
        <p>Đăng ký</p>
        <input type="text" name="fullName" placeholder="Họ tên" required
               <c:if test="${success == 'false'}">value="${user.fullName}" </c:if>
        ><br>
        <input type="number" name="phone" placeholder="Số điện thoại" maxlength="10" pattern="^0[0-9]{9}$" title="Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số" required
               <c:if test="${success == 'false'}">value="${user.phone}" </c:if>
        ><br>
        <input type="password" name="password" placeholder="Mật khẩu" minlength="6" title="Mật khẩu ít nhất có 6 ký tự" required
               <c:if test="${success == 'false'}">value="${user.password}" </c:if>
        ><br>
        <input type="password" name="confirmPassword" placeholder="Xác nhận mật khẩu" title="Các mật khẩu phải khớp nhau" required
               <c:if test="${success == 'false'}">value="${confirmPassword}" </c:if>
        ><br>
        <span>${errorMessage}</span>
        <input type="submit" value="Đăng ký"><br>
        <a href="/authenticate?action=login">Bạn đã có tài khoản? Đăng nhập ngay</a>
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
