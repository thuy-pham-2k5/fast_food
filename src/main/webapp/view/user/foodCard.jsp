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
        padding: 12px 12px;
        margin: 0;
        display: inline-flex;
    }

    .food-card a {
        border-radius: 8px;
        position: relative;
        transition: box-shadow 0.3s ease, transform 0.3s ease;
    }

    .food-card a:hover {
        box-shadow: 0 5px 7px rgba(255, 0, 48, 0.2);
        transform: scale(1.05);
    }

    .food-card-image {
        width: 185px;
        height: 135px;
        overflow: hidden;
        position: relative;
        border-radius: 8px 8px 0 0;
        border: 1px solid lightgray;
    }

    .food-card-image img {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    .food-card-inform {
        width: 185px;
        border-radius: 0 0 8px 8px;
        border: 1px solid lightgray;
    }

    .food-card-inform p, form {
        margin: 0;
        padding: 5px 8px;
    }

    .food-card-inform p {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .food-card-inform form {
        display: flex;
        justify-content: flex-end;
    }

</style>

<div class="food-card">
    <a>
        <div class="food-card-image">
            <img src="${param.foodImage}" alt="Error">
        </div>
        <div class="food-card-inform">
            <p>${param.foodName}</p>
            <p>${param.foodPrice} $</p>
            <form action="/home-user?action=addToCart&id=${param.foodId}" method="post">
                <button class="addToCart" data-food-id="${param.foodId}">Thêm vào giỏ</button>
            </form>
        </div>
    </a>
</div>