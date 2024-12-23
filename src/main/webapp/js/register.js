const passwordInput = document.querySelector('input[name="password"]');
const confirmPasswordInput = document.querySelector('input[name="confirmPassword"]');

confirmPasswordInput.addEventListener("input", function () {
    const password = passwordInput.value;
    const confirmPassword = confirmPasswordInput.value;
    if (confirmPassword === password) {
        this.setCustomValidity("");
    } else {
        this.setCustomValidity("Các mật khẩu phải khớp nhau");
    }
});
