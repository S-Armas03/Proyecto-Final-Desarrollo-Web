// URL base de tu Backend Spring Boot
const API_URL = "http://localhost:8080"; 

window.onload = cargarLuchadores;

// --- 1. CARGAR LUCHADORES ---
async function cargarLuchadores() {
    const contenedor = document.getElementById("contenido");
    contenedor.innerHTML = "<h2>Cargando luchadores...</h2>";

    try {
        const response = await fetch(`${API_URL}/luchadores`);
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const luchadores = await response.json();

        let html = `<h2>Listado de Luchadores</h2><div class="grid-container">`;

        luchadores.forEach(l => {
            // Definir color según bando
            const badgeClass = (l.bando === 'Rudo' || l.bando === 'Heel') ? 'bg-rudo' : 'bg-tecnico';
            
            // Imagen Placeholder (Gris con texto) ya que no tenemos URLs reales en la BD aún
            const imagen = `https://placehold.co/400x300?text=${l.nombre.replace(/ /g, "+")}`;

            html += `
            <div class="card">
                <img src="${imagen}" class="card-img-top" alt="${l.nombre}">
                <div class="card-body">
                    <h3 class="card-title">${l.nombre}</h3>
                    <p class="card-text"><em>"${l.apodo}"</em></p>
                    <span class="badge ${badgeClass}">${l.bando}</span>
                    <hr>
                    <p class="card-text"><strong>Marca:</strong> ${l.marca ? l.marca.nombre : 'Sin Marca'}</p>
                </div>
            </div>
            `;
        });

        html += `</div>`;
        contenedor.innerHTML = html;

    } catch (error) {
        console.error("Error:", error);
        contenedor.innerHTML = `<p style='color:red; font-weight:bold;'>Error al conectar con el Backend.</p>
                                <p>Asegúrate de que Spring Boot esté corriendo en el puerto 8080 y no haya errores en la consola de Java.</p>`;
    }
}

// --- 2. CARGAR MARCAS ---
async function cargarMarcas() {
    const contenedor = document.getElementById("contenido");
    contenedor.innerHTML = "<h2>Cargando marcas...</h2>";

    try {
        const response = await fetch(`${API_URL}/marcas`);
        const marcas = await response.json();

        let html = `<h2>Promociones Registradas</h2>
                    <ul style="list-style: none; padding: 0;">`;
        
        marcas.forEach(m => {
            html += `
            <li style="background: white; padding: 15px; margin-bottom: 10px; border-left: 5px solid #27ae60; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">
                <strong>${m.nombre}</strong> - <small>${m.pais}</small>
            </li>`;
        });
        html += "</ul>";
        contenedor.innerHTML = html;
    } catch (error) {
        contenedor.innerHTML = "<p>Error al cargar marcas. Revisa la consola (F12).</p>";
        console.error(error);
    }
}

// --- 3. CARGAR EVENTOS (PENDIENTE) ---
async function cargarEventos() {
     const contenedor = document.getElementById("contenido");
     // Aquí harías: fetch(`${API_URL}/eventos`)
     contenedor.innerHTML = "<h2>/Eventos.html</p>";
}

// --- 4. CARGAR CAMPEONATOS (PENDIENTE) ---
async function cargarCampeonatos() {
     const contenedor = document.getElementById("contenido");
     // Aquí harías: fetch(`${API_URL}/campeonatos`)
     contenedor.innerHTML = "<h2> Campeonatos Activos</h2><p>Funcionalidad pendiente de conectar al endpoint /campeonatos.</p>";
}