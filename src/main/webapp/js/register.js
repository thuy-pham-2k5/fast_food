function validateForm() {
    const password = document.querySelector('input[name="password"]').value;
    const confirmPassword = document.querySelector('input[name="confirmPassword"]').value;

    if (password !== confirmPassword) {
        confirmPassword.setCustomValidity("Mật khẩu và Xác nhận mật khẩu không khớp!");
    }
}
