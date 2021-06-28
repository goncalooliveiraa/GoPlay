window.onload = function() {
    loadTorneios();
}

async function loadTorneios() {
    try {
        let torneios = await $.ajax({
            url: "/api/torneios/lista",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("torneios");
        let html = "";
        for (const torneio of torneios) {
            html+="<tr><td>"+torneio.data + " </td>" +
            "<td>"+torneio.tipoJogo +"</td>"+
            "<td>"+torneio.freguesia+"</td>"+
            "<td>"+torneio.nome+"</td>"+
            "<td>"+torneio.numJogadores+"</td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {

    }
}