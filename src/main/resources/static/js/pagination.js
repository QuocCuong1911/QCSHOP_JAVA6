let link = document.getElementsByClassName("link");
let currentValue = 1;

function activeLink() {
    for (l of link) {
        l.classList.remove("active")
    }
    event.target.classList.add("active")
    currentValue = event.target.value;
}

function backBtn() {
    console.log(" back " + link.length)
    if (currentValue > 1) {
        for (l of link) {
            l.classList.remove("active")
        }
        currentValue--;
        link[currentValue - 1].classList.add("active")
    }
}

function nextBtn() {
    console.log(" next " + link.length)
    if (currentValue < link.length) {
        for (l of link) {
            l.classList.remove("active")
        }
        currentValue++;
        link[currentValue - 1].classList.add("active")
    }
}