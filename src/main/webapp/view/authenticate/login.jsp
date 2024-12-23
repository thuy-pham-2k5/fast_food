<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng nhập tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="/js/authenticate/login.js" defer></script>
</head>
<body>

<div class="container">
    <form action="/authenticate?action=login" method="post">
        <p>Đăng nhập</p>
        <input type="number" id="phone" name="phone" placeholder="Số điện thoại" required><br>
        <input type="password" id="password" name="password" placeholder="Mật khẩu" required><br>
        <span>
            ${sessionScope.errorMessage}
            <%
                session.removeAttribute("errorMessage");
            %>
        </span><br>
        <input type="submit" value="Đăng nhập"><br>
        <a href="/authenticate?action=signup">Bạn chưa có tài khoản? Đăng ký ngay</a>
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
