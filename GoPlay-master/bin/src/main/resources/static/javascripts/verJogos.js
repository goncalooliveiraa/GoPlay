window.onload = function() {
    loadJogos();
}

async function loadJogos() {
    try {
        let jogos = await $.ajax({
            url: "/api/jogos/lista",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("jogos");
        let html = "";
        for (const jogo of jogos) {
            html+="<tr><td>"+jogo.data + " </td>" +
            "<td>"+jogo.adversario +"</td>"+
            "<td>"+jogo.freguesia+"</td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {

    }
}