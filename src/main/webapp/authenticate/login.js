const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");
const phone = document.getElementById("phone");
const password = document.getElementById("password");
phone.addEventListener("input", function () {
    const value = this.value;
    if (value.length !== 10) {
        this.setCustomValidity("Số điện thoại phải bao gồm 10 chữ số");
    } else {
        this.setCustomValidity("");
    }
});

password.addEventListener("input", function () {
    const value = this.value;
    if (value.length < 6) {
        this.setCustomValidity("Mật khẩu phải có từ 6 chữ số trở lên");
    } else {
        this.setCustomValidity("");
    }
});
signInBtn.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

fistForm.addEventListener("submit", (e) => e.preventDefault());
secondForm.addEventListener("submit", (e) => e.preventDefault());