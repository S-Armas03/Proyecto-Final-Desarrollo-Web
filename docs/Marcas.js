const API_URL = "https://proyecto-final-desarrollo-web-production.up.railway.app/marcas";

window.onload = () => obtenerMarcas();

async function obtenerMarcas() {
    const contenedor = document.getElementById("contenedor-marcas");

    try {
        const res = await fetch(API_URL);
        const marcas = await res.json();

        contenedor.innerHTML = "";

        marcas.forEach(marca => {
            const card = document.createElement("div");
            card.className = "card";

            card.innerHTML = `
                <div class="card-body">
                    <h3>${marca.nombre}</h3>
                    <p><strong>País:</strong> ${marca.pais}</p>
                    <span class="badge">ID: ${marca.id_marca}</span>
                </div>
            `;

            contenedor.appendChild(card);
        });

    } catch (e) {
        console.error(e);
        contenedor.innerHTML = "<p>Error al cargar marcas</p>";
    }
}
