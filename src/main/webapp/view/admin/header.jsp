<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .menu {
        background-color: red;
        height: 50px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);    }

    .menu-button {
        display: flex;
        flex: 1; /* Take up half of the space */
    }

    .menu-button a {
        text-decoration: none;
        display: inline-block;
        padding: 10px;
        margin-left: 30px;
        color: #ffffff;
    }

    .menu-button a:hover {
        color: black;
    }

    .menu-icon {
        display: flex;
        justify-content: flex-end; /* Align icons to the right */
        flex: 1; /* Take up the other half of the space */
    }

    .menu-icon a {
        margin-left: 30px;
    }

    .menu-button img,
    .menu-icon img {
        width: 25px;
        height: 25px;
    }
</style>

<div class="menu">
    <div class="menu-button">
            <a href="#">Trang chủ</a>
            <a href="#">Món ăn</a>
            <a href="#">Đơn hàng</a>
            <a href="#">Khách hàng</a>
        <div class="menu-icon">
            <a href="#"><img src="${pageContext.request.contextPath}/image/user.png" alt="Error"></a>
            <a href="#"><img src="${pageContext.request.contextPath}/image/exit.png" alt="Error"></a>
        </div>
    </div>
</div>