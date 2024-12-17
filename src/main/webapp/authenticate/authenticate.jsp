<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng nhập - Đăng ký tài khoản</title>
    <link rel="stylesheet" href="/authenticate/authenticate.css">
    <script src="/authenticate/authenticate.js" defer></script>
</head>
<body>
<div class="container right-panel-active">
    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form action="/authenticate/sign-up" method="post" class="form" id="form1">
            <h2 class="form__title">Đăng ký</h2>
            <input type="number" id="phone" required name="phone" placeholder="Số điện thoại" class="input" />
            <input type="password" id="password" required name="password" placeholder="Mật khẩu" class="input" />
            <input type="text" required name="fullName" placeholder="Tên của bạn" class="input" />
            <button class="btn">Đăng ký</button>
        </form>
    </div>

    <!-- Sign In -->
    <div class="container__form container--signin">
        <form action="#" class="form" id="form2">
            <h2 class="form__title">Đăng nhập</h2>
            <input type="number" placeholder="Số điện thoại" class="input" />
            <input type="password" placeholder="Mật khẩu" class="input" />
            <a href="#" class="link">Forgot your password?</a>
            <button class="btn">Đăng nhập</button>
        </form>
    </div>

    <!-- Overlay -->
    <div class="container__overlay">
        <div class="overlay">
            <div class="overlay__panel overlay--left">
                <h3 style="color: white">Bạn đã có tài khoản?</h3>
                <button class="btn1" id="signIn">Đăng nhập ngay</button>
            </div>
            <div class="overlay__panel overlay--right">
                <h3 style="color: white">Bạn vẫn chưa có tài khoản?</h3>
                <button class="btn1" id="signUp">Đăng ký ngay</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
