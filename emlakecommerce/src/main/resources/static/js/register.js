function openModal(type) {
    let modalElement = document.getElementById("authModal");
    let modal = new bootstrap.Modal(modalElement);

    document.getElementById("modalTitle").innerText = type === "loginModal" ? "Daxil ol" : "Qeydiyyat";
    document.getElementById("loginModal").style.display = type === "loginModal" ? "block" : "none";
    document.getElementById("registerModal").style.display = type === "registerModal" ? "block" : "none";

    modal.show();
}

// Modal daxilində login və qeydiyyatı dəyişmək üçün
function toggleModal() {
    let loginForm = document.getElementById("loginModal");
    let registerForm = document.getElementById("registerModal");
    let title = document.getElementById("modalTitle");

    if (loginForm.style.display === "block") {
        loginForm.style.display = "none";
        registerForm.style.display = "block";
        title.innerText = "Qeydiyyat";
    } else {
        loginForm.style.display = "block";
        registerForm.style.display = "none";
        title.innerText = "Daxil ol";
    }
}

// **Sayfa yüklendiğinde modalın otomatik açılmasını sağla**
window.onload = function () {
    let showLoginModal = document.getElementById("showLoginModalFlag");
    if (showLoginModal) {
        openModal("loginModal");
    }
};

// **Modal bağlananda arka fonu temizle**
document.getElementById("authModal").addEventListener("hidden.bs.modal", function () {
    document.querySelectorAll(".modal-backdrop").forEach(backdrop => {
        backdrop.remove();
    });
    document.body.classList.remove("modal-open"); // Sayfanın kilitlenmesini önle
});

// **Modal açıldıqda arka fonun üst-üstə gəlməsini önlə**
document.getElementById("authModal").addEventListener("show.bs.modal", function () {
    let existingBackdrop = document.querySelector(".modal-backdrop");
    if (!existingBackdrop) {
        let backdrop = document.createElement("div");
        backdrop.className = "modal-backdrop fade show";
        document.body.appendChild(backdrop);
    }
});
