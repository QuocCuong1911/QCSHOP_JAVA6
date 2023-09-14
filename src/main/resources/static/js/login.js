var loginform = document.getElementById("loginID");
	var signupform = document.getElementById("SignupID");
	var indi = document.getElementById("Indicator");

	function signup() {
		signupform.style.transform = "translateX(0px)";
		loginform.style.transform = "translateX(0px)";
		indi.style.transform = "translateX(100px)";
	}

	function login() {
		signupform.style.transform = "translateX(300px)";
		loginform.style.transform = "translateX(300px)";
		indi.style.transform = "translateX(0px)";
	}
	// var productPriceElement = document.getElementById("productPrice");
	// if (productPriceElement) {
	//     var price = parseFloat(productPriceElement.textContent);
	//     var formattedPrice = price.toLocaleString("vi-VN", { style: "currency", currency: "VND" });
	//     productPriceElement.textContent = formattedPrice;
	// }