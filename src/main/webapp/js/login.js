const phone = document.getElementById("phone");
const password = document.getElementById("password");

phone.addEventListener("input", function () {
    const value = this.value;
    if (value.length!== 10) {
        this.setCustomValidity("Số điện thoại phải gồm 10 chữ số");
    } else {
        this.setCustomValidity("");
    }
})

password.addEventListener("input", function () {
    const value = this.value;
    if (value.length<6) {
        this.setCustomValidity("Mật khẩu phải nhiều hơn 6 chữ số");
    } else {
        this.setCustomValidity("");
    }
})