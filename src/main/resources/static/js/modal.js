const postModalTrigger = document.querySelector(".post-modal-trigger")
const postModal = document.getElementById("postModal")

const cancelBtn = document.querySelector(".cancel")


postModalTrigger.addEventListener("focus", () => {
    postModal.style.display = "block";
    console.log("focus")
})

cancelBtn.onclick = (e) => {
    e.preventDefault()
    postModal.style.display = "none";
}