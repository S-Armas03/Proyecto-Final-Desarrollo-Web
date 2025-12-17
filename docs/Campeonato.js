window.onload = () => {
    fetch("https://proyecto-final-desarrollo-web-production.up.railway.app/Campeonatos.html")
        .then(res => res.json())
        .then(data => {
            const contenedor = document.getElementById("contenedor-campeonatos");
            contenedor.innerHTML = "";

            data.forEach(c => {
                const card = document.createElement("div");
                card.className = "card";

                card.innerHTML = `
                    <img src="https://cdn-icons-png.flaticon.com/512/2503/2503508.png" class="card-img-top">
                    <div class="card-body">
                        <h3 class="card-title">${c.nombre}</h3>
                        <p>${c.division}</p>
                        <span class="badge bg-tecnico">Marca ${c.id_marca}</span>
                    </div>
                `;

                contenedor.appendChild(card);
            });
        })
        .catch(err => console.error(err));
};

