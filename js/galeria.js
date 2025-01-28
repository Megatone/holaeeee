document.addEventListener('DOMContentLoaded', () => {
    // Selección de elementos
    const carousel = document.querySelector('.carousel-inner');
    const indicators = document.querySelectorAll('.carousel-indicators button');
    let currentIndex = 0;

    // Actualizar carrusel
    function updateCarousel(index) {
        const offset = -index * 100; // Mueve el carrusel en porcentaje
        carousel.style.transform = `translateX(${offset}%)`;

        // Actualizar indicadores
        indicators.forEach(btn => btn.classList.remove('active'));
        indicators[index].classList.add('active');

        currentIndex = index; // Actualizar índice actual
    }

    // Navegación manual con botones
    document.getElementById('prev').addEventListener('click', () => {
        const index = currentIndex > 0 ? currentIndex - 1 : indicators.length - 1;
        updateCarousel(index);
    });

    document.getElementById('next').addEventListener('click', () => {
        const index = currentIndex < indicators.length - 1 ? currentIndex + 1 : 0;
        updateCarousel(index);
    });

    // Navegación manual con indicadores
    indicators.forEach((btn, i) => {
        btn.addEventListener('click', () => updateCarousel(i));
    });
});