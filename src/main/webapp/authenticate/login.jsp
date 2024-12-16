<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/authenticate/login.css">
    <script src="/authenticate/login.js" defer></script>
</head>
<body>
<div class="container right-panel-active">
    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form action="/authenticate/sign-up" method="post" class="form" id="form1">
            <h2 class="form__title">Sign Up</h2>
            <input type="number" name="phone" placeholder="Phone" class="input" />
            <input type="password" name="password" placeholder="Password" class="input" />
            <input type="text" name="fullName" placeholder="Full Name" class="input" />
            <button class="btn">Sign Up</button>
        </form>
    </div>

    <!-- Sign In -->
    <div class="container__form container--signin">
        <form action="#" class="form" id="form2">
            <h2 class="form__title">Sign In</h2>
            <input type="email" placeholder="Email" class="input" />
            <input type="password" placeholder="Password" class="input" />
            <a href="#" class="link">Forgot your password?</a>
            <button class="btn">Sign In</button>
        </form>
    </div>

    <!-- Overlay -->
    <div class="container__overlay">
        <div class="overlay">
            <div class="overlay__panel overlay--left">
                <h3 style="color: white">Already have an account?</h3>
                <button class="btn1" id="signIn">Sign In</button>
            </div>
            <div class="overlay__panel overlay--right">
                <h3 style="color: white">Don't have an account?</h3>
                <button class="btn1" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
