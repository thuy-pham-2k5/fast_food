<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Fast Food - Bảng điều khiển</title>
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<main>
    <div class="all">
        <div class="div-search-add">
            <div class="div-child">
                <form action="/food?action=search" method="post">
                    <input type="text" name="keyword" placeholder="Tìm kiếm" width="300px">
                    <input type="submit" value="Tìm kiếm">
                </form>
            </div>
            <div class="div-child div-right">
                <a href="/food" class="a-load"><img class="img-load"
                                                    src="https://img.lovepik.com/free-png/20211201/lovepik-pink-two-way-arrow-png-image_401232107_wh1200.png"
                                                    width="40px" alt="Error"></a>
                <a href="/food?action=add">
                    <button class="button-add">&#10055; Thêm món</button>
                </a>
            </div>

        </div>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Hình ảnh</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Mô tả</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Tổng giá</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="food" items="${foods}">
                    <tr>
                        <td>${food.getId()}</td>
                        <td><img src="${food.getImageUrl()}" alt="Error" width="100px"></td>
                        <td>${food.getName()}</td>
                        <td>${food.getDescription()}</td>
                        <td>${food.getPrice()} $</td>
                        <td>${food.getQuantity()}</td>
                        <td><fmt:formatNumber value="${food.getPrice() * food.getQuantity()}" pattern="#, ##0.00"/> $
                        </td>
                        <td>
                            <a href="/food?action=edit&idFood=${food.id}"><img
                                    src="https://i.pinimg.com/736x/90/3f/e3/903fe3b2b3a404e8fa8f0e1a1dddc1be.jpg"
                                    width="30px"
                                    alt="Error"></a>
                            <a href="/food?action=delete&idFood=${food.id}"><img
                                    src="https://i.pinimg.com/236x/a5/3c/28/a53c286dfdf33b31a0c7edf31fb5d67c.jpg"
                                    width="30px"
                                    alt="Error"></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
