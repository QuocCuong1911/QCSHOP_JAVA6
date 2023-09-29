const button = document.querySelector(".notificationBtn")
	const notification = document.querySelector(".notification")
	const closeIcon = document.querySelector(".close")
	const progress = document.querySelector(".progress")

	if (button) {
	    button.addEventListener("click", (event) => {
	        event.preventDefault();
	        notification.classList.add("active")
	        progress.classList.add("active")

	        setTimeout(() => {
	            notification.classList.remove("active")
	        }, 3000)

	        setTimeout(() => {
	            progress.classList.remove("active")
	        }, 3300)
	    })
	}

	if (closeIcon) {
	    closeIcon.addEventListener("click", () => {
	        notification.classList.remove("active")

	        setTimeout(() => {
	            progress.classList.remove("active")
	        }, 300)
	    })

	}