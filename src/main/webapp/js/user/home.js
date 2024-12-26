document.querySelectorAll('.addToCart').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();

        const foodId = this.getAttribute('data-food-id');
        const alertMessage = document.getElementById('alertMessage');
        const alertBox = document.getElementById('customAlert');
        const overlay = document.getElementById('overlay');

        if (sessionStorage.getItem(foodId)) {
            alertMessage.textContent = "Món ăn đã được thêm vào giỏ";
        } else {
            sessionStorage.setItem(foodId, true);
            alertMessage.textContent = "Thêm vào giỏ thành công!";
        }

        alertBox.style.display = 'block';
        overlay.style.display = 'block';

        const form = this.closest('form');

        setTimeout(function () {
            alertBox.style.display = 'none';
            overlay.style.display = 'none';
            form.submit();
        }, 1000);
    });
});

