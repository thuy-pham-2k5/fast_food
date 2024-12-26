document.querySelectorAll('.addToCart').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();

        // Hiển thị cửa sổ thông báo
        const alertBox = document.getElementById('customAlert');
        const overlay = document.getElementById('overlay');
        alertBox.style.display = 'block';
        overlay.style.display = 'block';

        // Tự động đóng cửa sổ sau 2 giây
        setTimeout(function () {
            alertBox.style.display = 'none';
            overlay.style.display = 'none';
        }, 1000);
    });
});
