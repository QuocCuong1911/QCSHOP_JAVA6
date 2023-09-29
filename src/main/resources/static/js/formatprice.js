// Hàm định dạng giá trị
function formatPriceElements() {
    // Lấy danh sách tất cả các phần tử có class "format-price"
    const priceElements = document.querySelectorAll('.format-price');

    // Duyệt qua danh sách các phần tử và áp dụng hàm formatPriceElements cho mỗi phần tử
    priceElements.forEach((element) => {
        const text = element.textContent.trim(); // Lấy nội dung văn bản và loại bỏ khoảng trắng thừa
        const parts = text.split(':'); // Tách chuỗi theo dấu ':'
        if (parts.length === 2) {
            // Nếu có đúng 2 phần tử sau khi tách, tiến hành định dạng
            const price = parseFloat(parts[1].trim().replace(/,/g, '')); // Loại bỏ dấu phẩy nếu có
            const formattedPrice = `Price: ${price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}`; // Định dạng số và nối lại chuỗi
            element.textContent = formattedPrice; // Gán lại nội dung đã định dạng vào phần tử
        }
    });


}
document.addEventListener('DOMContentLoaded', formatPriceElements);
// function formatPriceChange() {
//     const priceElements2 = document.querySelectorAll('.format-price2');
//     priceElements2.forEach((element) => {
//         const price = parseFloat(element.textContent.trim()); // Lấy nội dung văn bản và loại bỏ khoảng trắng thừa     

//         const formattedPrice = `${price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}`; // Định dạng số và nối lại chuỗi

//         element.textContent = formattedPrice; // Gán lại nội dung đã định dạng vào phần tử

//     });
// }
// Chờ đến khi DOM đã được tải và sẵn sàng

// document.addEventListener('DOMContentLoaded', formatPriceChange);