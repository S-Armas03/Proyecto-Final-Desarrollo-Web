const API_URL = "/luchador";

window.onload = () => obtenerLuchadores();

async function obtenerLuchadores() {
    const contenedor = document.getElementById("contenedor-luchadores");

    try {
        const response = await fetch(API_URL);
        const luchadores = await response.json();

        contenedor.innerHTML = "";

        luchadores.forEach(l => {
            const card = document.createElement("div");
            card.className = "card";

            let clase = "bg-tecnico";
            if (l.bando?.toLowerCase().includes("rudo")) clase = "bg-rudo";

            card.innerHTML = `
                <img src="https://cdn-icons-png.flaticon.com/512/1365/1365696.png" class="card-img-top">
                <div class="card-body">
                    <h3 class="card-title">${l.apodo}</h3>
                    <p>${l.nombre}</p>
                    <span class="badge ${clase}">${l.bando}</span>
                </div>
            `;

            contenedor.appendChild(card);
        });

    } catch (e) {
        console.error(e);
        contenedor.innerHTML = "<p>Error cargando luchadores</p>";
    }
}

