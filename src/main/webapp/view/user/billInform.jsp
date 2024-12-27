<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
        }

        main {
            max-width: 1200px;
            margin: 10px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse; /* Merges borders */
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd; /* Border for each cell */
        }

        th {
            background-color: #f2f2f2; /* Light gray background for header */
            color: #333; /* Dark text for header */
        }

        td {
            text-align: center; /* Center content for all cells */
        }

        td:nth-child(2) {
            text-align: left; /* Left align for the "Tên món" column */
        }

        tr:hover {
            background-color: #f5f5f5; /* Light gray background on row hover */
        }

        img {
            border-radius: 5px; /* Rounded corners for images */
            max-width: 100%; /* Responsive image */
            height: auto; /* Maintain aspect ratio */
        }
    </style>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div>
        <table>
            <tr>
                <th>Hình ảnh</th>
                <th>Tên món</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th>Trạng thái</th>
            </tr>
            <c:forEach var="food" items="${foods}">
                <tr>
                    <td><img src="${food.imageUrl}" alt="Error" width="100px"/></td>
                    <td>${food.name}</td>
                    <td>${food.quantity}</td>
                    <td>${food.price * food.quantity}</td>
                    <td>${food.orderStatus}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>
