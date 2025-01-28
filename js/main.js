document.addEventListener('DOMContentLoaded', () => {
    // Seleccionar elementos
    const hamburger = document.getElementById('hamburger');
    const navLinks = document.getElementById('navLinks');

    // Alternar la visibilidad del menúcls
    hamburger.addEventListener('click', () => {
        navLinks.classList.toggle('active'); // Añade o elimina la clase 'active'
    });

});