<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .table {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: auto;
            max-width: 800px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .status-icon img {
            width: 35px;
            height: 35px;
        }
        .status-icon {
            border: none;
            background: transparent;
            height: 20px;
        }
        tr:hover{
            background-color: #f1f1f1;
            border-color: #f1f1f1;

        }
    </style>
    <script>
        function showAlert() {
            var result = confirm("Are you sure you want to change the status?");
            if (result) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<div class="table">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Phone</th>
            <th>Full Name</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getPhone()}</td>
                <td>${user.fullName}</td>
                <td>
                    <form action="/customer?action=changeStatus&id=${user.id}" method="post" onsubmit="return showAlert()">
                        <button type="submit" class="status-icon">
                            <c:if test="${user.status == true}">
                                <img src="https://cdn1.iconfinder.com/data/icons/warnings-and-dangers/400/Warning-02-512.png" alt="Active Status">
                            </c:if>
                            <c:if test="${user.status == false}">
                                <img src="https://cdn2.iconfinder.com/data/icons/web-and-apps-interface/32/Cancel-512.png" alt="Inactive Status">
                            </c:if>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
