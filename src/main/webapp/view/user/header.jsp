<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .menu {
        background-color: red;
        height: 70px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        padding: 0 20px;
        margin: 0;
    }

    .menu-button {
        display: flex;
        flex: 1;
        align-items: center; /* Center items in this flex container */
    }

    .menu-button a {
        text-decoration: none;
        padding: 0 15px; /* Adjusted padding for better vertical centering */
        color: #ffffff;
    }

    .menu-button a img {
    }

    .menu-button a:hover {
        color: black;
    }

    .menu-icon {
        display: flex;
        justify-content: flex-end;
        flex: 1;
        align-items: center;
    }

    .menu-icon input {
        height: 40px;
        width: 500px;
        border-radius: 20px;
        padding-left: 15px;
        font-size: 15px;
        border-color: #ffffff;
    }
    .menu-icon button {
        height: 40px;
        margin-left: 10px;
        border: none;
        background: transparent;
    }

    .menu-button img {
        width: 40px;
        height: 40px;
    }

    .menu-icon img {
        width: 30px;
        height: 30px;
    }
</style>
<div class="menu">
    <div class="menu-button">
        <a href="/home-user" ><img style="border-radius: 50%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlERRYmFAppRLJUU7Ki5EMSqOnDXCtW8FrgA&s"></a>
        <a href="#">Gà tây,bò hầm</a>
        <a href="#">Bánh kem</a>
        <a href="#">Kẹo</a>
        <div class="menu-icon">
            <input type="text" placeholder="Tìm món ăn qua tên">
            <button type="submit">
                <img src="https://cdn.iconfinder.com/stored_data/2047535/128/png?token=1735210197-riA83owJKKYunY7RL%2F0NOVXONHhGaEX2S%2FlCZd06vyY%3D" alt="Tìm kiếm">
            </button>
            <a href="/cart-user"><img src="https://cdn.iconfinder.com/stored_data/2048338/128/png?token=1735261811-moUhnQ8Tz2n23WxD1lo%2BuhT8%2FEAC8RtKIcBpG%2BlRo8g%3D" alt="Error"></a>
            <a href="#"><img src="https://cdn.iconfinder.com/stored_data/2048347/128/png?token=1735262562-eY0OyFvqi6f2UUipXuhH1WaRvIAOOS8CHr%2FYCVN6NBI%3D"></a>
            <a href="logout"><img src="https://cdn.iconfinder.com/stored_data/2046252/128/png?token=1735098591-sBbCIG%2FbufbHVTkg2e56mmgHxyvMCs8LJA2T0WoexfU%3D" alt="Error"></a>
        </div>
    </div>
</div>
