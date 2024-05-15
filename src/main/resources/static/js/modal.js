const postModalTrigger = document.querySelector(".post-modal-trigger")
const postModal = document.getElementById("postModal")

const cancelBtn = document.querySelector(".cancel")

const previewImage = () => {
    document.getElementById('file').addEventListener('change', function(event) {
        const file = event.target.files[0];
        if (file) {
            
            const reader = new FileReader();
            reader.onload = function(e) {
                // preview.innerHTML = `<img src = ${e.target.result}/>`
                const previewImg = document.querySelector(".preview img")
                const img = document.querySelector('.custom-file-input label img');
                previewImg.src = e.target.result;
            }
            reader.readAsDataURL(file);
        }
    });
}

postModalTrigger.addEventListener("focus", () => {
    postModal.style.display = "block";
    previewImage()
})

cancelBtn.onclick = (e) => {
    e.preventDefault()
    postModal.style.display = "none";
}