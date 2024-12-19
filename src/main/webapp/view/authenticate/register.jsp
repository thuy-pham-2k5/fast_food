<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="container">
    <c:if test="${param.success eq 'true'}">
        <script>alert("Đăng ký thành công!");</script>
    </c:if>
    <form action="/authenticate?action=signup" method="post" onsubmit="return validateForm()">
        <p>Đăng ký</p>

        <input type="text" name="fullName" placeholder="Họ tên" required><br>
        <input type="text" name="phone" placeholder="Số điện thoại" maxlength="10" pattern="^0[0-9]{9}$" title="Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số" required><br>
        <input type="password" name="password" placeholder="Mật khẩu" minlength="6" title="mật khẩu ít nhất có 6 ký tự" required><br>
        <input type="password" name="confirmPassword" placeholder="Xác nhận mật khẩu" required><br>
        <input type="submit" value="Đăng ký"><br>
        <label>Bạn đã có tài khoản? </label><a href="/authenticate?action=login">Đăng nhập ngay</a>
    </form>
    <script>
        function validateForm() {
            const password = document.querySelector('input[name="password"]').value;
            const confirmPassword = document.querySelector('input[name="confirmPassword"]').value;

            if (password !== confirmPassword) {
                alert("Mật khẩu và Xác nhận mật khẩu không khớp!");
            }
        }
    </script>

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
