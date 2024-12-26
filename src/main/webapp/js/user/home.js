document.querySelectorAll('.addToCart').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();

        const alertBox = document.getElementById('customAlert');
        const overlay = document.getElementById('overlay');
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

