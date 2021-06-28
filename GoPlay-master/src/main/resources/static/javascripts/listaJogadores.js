window.onload = function() {
    loadListaJogadores();
}

async function loadListaJogadores() {
    try {
        let jogadores = await $.ajax({
            url: "/api/jogadores/lista",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("jogadores");
        let html = "";
        for (const jogador of jogadores) {
            html+="<tr><td>"+jogador.nome + " "+"</td>"+
            "<td>"+jogador.apelido + " "+"</td>"+
            "<td>"+jogador.genero + " "+"</td>"+
            "<td>"+jogador.contacto+"</td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {

    }
}