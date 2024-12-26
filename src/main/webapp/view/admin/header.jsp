<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
.menu {
    background-color: red;
    height: 70px;
    display: flex;
    justify-content: space-between;
    align-items: center; /* This ensures vertical centering */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    padding: 0 20px; /* Optional: add padding for better spacing */
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
    align-items: center; /* Center items in this flex container */
}

.menu-icon a {
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
        <a href="#" ><img style="border-radius: 50%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlERRYmFAppRLJUU7Ki5EMSqOnDXCtW8FrgA&s"></a>
        <a href="#">Món ăn</a>
        <a href="#">Đơn hàng</a>
        <a href="/view/admin/customer.jsp">Khách hàng</a>
        <div class="menu-icon">
            <a href="#"><img src="https://cdn.iconfinder.com/stored_data/2046281/128/png?token=1735098682-AjRD4kHEi3ua6X8wZPE3ew2EFwyDmVJeqGyoiMoaQv8%3D    " alt="Error"></a>
            <a href="logout"><img src="https://cdn.iconfinder.com/stored_data/2046252/128/png?token=1735098591-sBbCIG%2FbufbHVTkg2e56mmgHxyvMCs8LJA2T0WoexfU%3D" alt="Error"></a>
        </div>
    </div>
</div>
