document.addEventListener('DOMContentLoaded', function() {
    const navItems = document.querySelectorAll('.header__nav__item');
    navItems.forEach(item => {
        if (item.href === window.location.href || item.href.includes("/?continue")) {
            item.classList.add('active')
        }
    });
});