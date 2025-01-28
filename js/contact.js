function validarFormulario() {
    // Obtener los valores de los campos
    const nombre = document.getElementById("nombre").value.trim();
    const email = document.getElementById("email").value.trim();
    const asunto = document.getElementById("asunto").value.trim();
    const mensaje = document.getElementById("mensaje").value.trim();

    // Validar el campo Nombre
    if (nombre === "") {
        alert("Por favor, ingrese su nombre.");
        return false;
    }

    // Validar el campo Email
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("Por favor, ingrese un email válido.");
        return false;
    }

    // Validar el campo Asunto
    if (asunto === "") {
        alert("Por favor, ingrese el asunto.");
        return false;
    }

    // Validar el campo Mensaje
    if (mensaje === "") {
        alert("Por favor, escriba un mensaje.");
        return false;
    }

    // Si todo es válido, enviar el formulario
    alert("Formulario enviado correctamente.");
    return true;
}