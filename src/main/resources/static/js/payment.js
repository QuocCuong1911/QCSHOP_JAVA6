const cardNumberInput = document.querySelectorAll(".number-check");

// Thêm sự kiện "input" để xử lý việc chỉ cho phép số
cardNumberInput.forEach(input => {
    input.addEventListener("input", function (event) {
        event.target.value = event.target.value.replace(/[^0-9]/g, '');
    });
})


let isDirectlySelected = true;

function disableInputs(value) {
    isDirectlySelected = value
    
    const inputsToDisable = document.querySelectorAll(".transfer-disabled");

    inputsToDisable.forEach(input => {
        if (isDirectlySelected) {
            input.classList.add("disabled");
            input.value = "";
        } else {
            input.classList.remove("disabled");
        }
    });
}