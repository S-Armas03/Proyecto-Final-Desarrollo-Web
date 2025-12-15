const API_URL = "http://localhost:8080";

window.onload = function() {
    obtenerEventos();
};

async function obtenerEventos() {
    const contenedor = document.getElementById("contenido-eventos");
    
    try {
        const response = await fetch(`${API_URL}/eventos`);
        if (!response.ok) throw new Error("Error en la red");
        
        const eventos = await response.json();
        
        let html = `<div class="events-list">`;

        eventos.forEach(e => {
            // Formatear fecha (asumiendo formato YYYY-MM-DD del backend)
            const fechaObj = new Date(e.fecha);
            // Ajuste de zona horaria simple para visualización correcta
            const fechaUser = new Date(fechaObj.getTime() + fechaObj.getTimezoneOffset() * 60000);
            
            const dia = fechaUser.getDate();
            const mes = fechaUser.toLocaleString('es-ES', { month: 'short' }).toUpperCase();
            const anio = fechaUser.getFullYear();

            html += `
            <div class="event-item">
                <div class="event-date">
                    <span class="day">${dia}</span>
                    <span class="year">${mes} ${anio}</span>
                </div>
                <div class="event-details">
                    <h3>${e.nombre}</h3>
                    <p class="event-location">📍 ${e.sede}</p>
                    <p><small>Organizado por: <strong>${e.marca ? e.marca.nombre : 'Independiente'}</strong></small></p>
                </div>
            </div>
            `;
        });

        html += `</div>`;
        contenedor.innerHTML = html;

    } catch (error) {
        console.error(error);
        contenedor.innerHTML = `<p style="color:red; text-align:center;">Error al cargar eventos.</p>`;
    }
}