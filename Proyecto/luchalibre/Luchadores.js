// URL de tu API
const API_URL = "http://localhost:8080";

window.onload = function() {
    obtenerLuchadores();
};

async function obtenerLuchadores() {
    const contenedor = document.getElementById("contenido-luchadores");
    
    try {
        const response = await fetch(`${API_URL}/luchadores`);
        if (!response.ok) throw new Error("Error en la red");
        
        const luchadores = await response.json();
        
        let html = `<div class="grid-container">`;

        luchadores.forEach(l => {
            // Lógica para color del bando
            let bandoClass = "bg-tecnico";
            if(l.bando === "Rudo" || l.bando === "Heel") bandoClass = "bg-rudo";
            if(l.bando === "Tweener") bandoClass = "bg-tweener";

            // Imagen por defecto si no hay URL
            const imagen = l.imagenUrl ? l.imagenUrl : `https://placehold.co/400x300?text=${l.nombre.replace(/ /g, "+")}`;

            html += `
            <div class="card">
                <img src="${imagen}" class="card-img-top" alt="${l.nombre}">
                <div class="card-body">
                    <h3 class="card-title">${l.nombre}</h3>
                    <p class="card-subtitle">"${l.apodo}"</p>
                    <span class="badge ${bandoClass}">${l.bando}</span>
                    <hr style="border-top: 1px solid #eee;">
                    <p style="font-size: 0.9rem; color: #555;">
                        <strong>Marca:</strong> ${l.marca ? l.marca.nombre : "Agente Libre"}
                    </p>
                </div>
            </div>
            `;
        });

        html += `</div>`;
        contenedor.innerHTML = html;

    } catch (error) {
        console.error(error);
        contenedor.innerHTML = `<p style="color:red; text-align:center;">Error al cargar los luchadores. Revisa que el Backend esté corriendo.</p>`;
    }
}