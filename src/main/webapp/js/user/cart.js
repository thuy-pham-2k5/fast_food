document.getElementById('checkbox').addEventListener('change', function () {
    const checkboxes = document.querySelectorAll('.checkbox');
    const isChecked = this.checked;
    checkboxes.forEach(function (checkbox) {
        checkbox.checked = isChecked;
    })
    calculateTotal();
})

document.getElementById("orderButton").addEventListener("click", function (){
    const rows = document.querySelectorAll('table tr');
    const selectedItems = new Map();
    rows.forEach(function (row) {
        const checkbox = row.querySelector('.checkbox');
        if (checkbox && checkbox.checked) {
            const foodId = row.querySelector('.foodId').innerText;
            const foodQuantity = row.querySelector('.quantity').value;
            selectedItems.set(foodId, foodQuantity);
        }
    });
    if (selectedItems.size>0) {
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '/cart-user?action=order';
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
        document.body.appendChild(form);
        form.submit();
    } else {
        alert('Vui lòng chọn ít nhất một món ăn');
    }
})

function calculateRowTotal(row) {
    const price = parseFloat(row.querySelector('.price').innerText);
    const quantity = parseFloat(row.querySelector('.quantity').value);
    let total = price * quantity;
    row.querySelector('.total').innerText = total;

}

function calculateTotal() {
    const checkboxes = document.querySelectorAll('.checkbox');
    const totals = document.querySelectorAll('.total');
    let amountPayment = 0;

    checkboxes.forEach(function (checkbox, index) {
        if (checkbox.checked) {
            amountPayment += parseFloat(totals[index].innerText);
        }
    });

    document.getElementById("amount").innerText = amountPayment;
}

const checkboxes = document.querySelectorAll('.checkbox');
const quantities = document.querySelectorAll('.quantity');
checkboxes.forEach(function (checkbox) {
    checkbox.addEventListener('change', calculateTotal);
})

quantities.forEach(function (quantity) {
    quantity.addEventListener('input', function () {
        const row = quantity.closest('tr');
        calculateRowTotal(row);
    });
});

calculateTotal();
