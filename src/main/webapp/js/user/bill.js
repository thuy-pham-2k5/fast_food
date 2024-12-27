document.getElementById("paymentButton").addEventListener("click", function () {
    const rows = document.querySelectorAll('table tr');
    const selectedItems = new Map();
    rows.forEach(function (row, index) {
        if (index === 0) return;
        const foodIdElement = row.querySelector('.foodId');
        const foodQuantityElement = row.querySelector('.quantity');
        if (foodIdElement && foodQuantityElement) {
            const foodId = foodIdElement.innerText;
            const foodQuantity = foodQuantityElement.innerText;
            selectedItems.set(foodId, foodQuantity);
        }
    });

    const address = document.getElementById('address').value;
    const payStatus = document.getElementById('pay_status').value;

    if (selectedItems.size > 0) {
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '/cart-user?action=payment';
        selectedItems.forEach(function (quantity, id) {
            const inputId = document.createElement('input');
            inputId.type = 'hidden';
            inputId.name = 'foodId';
            inputId.value = id;
            form.appendChild(inputId);

            const inputQuantity = document.createElement('input');
            inputQuantity.type = 'hidden';
            inputQuantity.name = 'foodQuantity';
            inputQuantity.value = quantity;
            form.appendChild(inputQuantity);
        })
        const inputAddress = document.createElement('input');
        inputAddress.type = 'hidden';
        inputAddress.name = 'address';
        inputAddress.value = address;
        form.appendChild(inputAddress);

        const inputPayStatus = document.createElement('input');
        inputPayStatus.type = 'hidden';
        inputPayStatus.name = 'pay_status';
        inputPayStatus.value = payStatus;
        form.appendChild(inputPayStatus);

        document.body.appendChild(form);
        form.submit();
    } else {
        alert('Vui lòng chọn ít nhất một món ăn');
    }
})

function calculateTotal() {
    const totals = document.querySelectorAll('.total');
    let amountPayment = 0;
    totals.forEach(function (total) {
        amountPayment += parseFloat(total.innerText);
    })
    document.getElementById("amount").innerText = amountPayment.toFixed(2);
}

calculateTotal();