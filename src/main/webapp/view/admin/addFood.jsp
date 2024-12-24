<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm món ăn</title>
    <link rel="stylesheet" href="/css/feature.css">
</head>
<body>
<div class="form-container">
    <h2>Cập nhật món ăn mới</h2>
    <form action="/food?action=add" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Tên món ăn</label>
            <input name="name" required type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Mô tả</label>
            <input name="description" required type="text" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail2" class="form-label">Giá</label>
            <input name="price" required type="number" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword2" class="form-label">Số lượng</label>
            <input name="quantity" required type="number" class="form-control" id="exampleInputPassword2">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword3" class="form-label">Link hình ảnh</label>
            <input name="imageUrl" required type="text" class="form-control" id="exampleInputPassword3">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
