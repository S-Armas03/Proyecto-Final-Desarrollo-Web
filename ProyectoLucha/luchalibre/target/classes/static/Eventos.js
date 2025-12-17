const API_URL = "/eventos";

window.onload = () => {
    cargarEventos();
};

async function cargarEventos() {
    const contenedor = document.getElementById("contenedor-eventos");

    try {
        const response = await fetch(API_URL);
        const eventos = await response.json();

        contenedor.innerHTML = "";

        eventos.forEach(evento => {

            const card = document.createElement("div");
            card.className = "card";

            // Imagen genérica
            const img = document.createElement("img");
            img.src = "https://cdn-icons-png.flaticon.com/512/2314/2314443.png";
            img.className = "card-img-top";
            img.alt = "Evento";

            // Cuerpo
            const body = document.createElement("div");
            body.className = "card-body";

            const titulo = document.createElement("h3");
            titulo.className = "card-title";
            titulo.textContent = evento.nombre;

            const fecha = document.createElement("p");
            fecha.className = "card-text";
            fecha.textContent = `📅 ${evento.fecha}`;

            const sede = document.createElement("p");
            sede.className = "card-text";
            sede.textContent = `📍 ${evento.sede}`;

            const badge = document.createElement("span");
            badge.className = "badge bg-marca";
            badge.textContent = `Marca ID: ${evento.id_marca}`;

            body.appendChild(titulo);
            body.appendChild(fecha);
            body.appendChild(sede);
            body.appendChild(badge);

            card.appendChild(img);
            card.appendChild(body);

            contenedor.appendChild(card);
        });

    } catch (error) {
        console.error(error);
        contenedor.innerHTML = "<p>Error al cargar eventos</p>";
    }
}

