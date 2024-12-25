<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/24/2024
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .food-card {
        padding: 8px;
    }
    .food-card a {
        border-radius: 8px;
        box-shadow: #ff0030;
    }
    .image-inform {
        width: 185px;
        height: 135px;
        border: 1px solid lightgray;
        border-radius: 8px;
        overflow: hidden;
        position: relative;
    }
    .image-inform img {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    .card-inform {
        border-radius: 0 0 6px 6px;
    }
    .food-inform {
        padding: 5px 8px;
    }
</style>
<div class="food-card">
    <a>
        <div class="image-inform">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSp6XfRxRsU9LAfnSU9WLcG6MA0BT3Fl4_DQg&s"
                 alt="Error">
        </div>
        <div class="card-inform">
            <div class="food-inform">

            </div>
            <div class="add-cart">

            </div>
        </div>
    </a>
</div>
<div style="width: 200px; height: 200px; background-color: lightblue; position: relative;">
    <div style="width: 50px; height: 50px; background-color: red; position: absolute; top: 10px; left: 10px;">
        Tôi là phần tử con
    </div>
</div>
