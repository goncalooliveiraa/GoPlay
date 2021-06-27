window.onload = function() {
    loadArbitros();
}

async function loadArbitros() {
    try {
        let arbitros = await $.ajax({
            url: "/api/arbitros/leaderboardA",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("arbitros");
        let html = "";
        for (const arbitro of arbitros) {
            html+="<tr><td>"+arbitro.nome + " "+"</td>"+
            "<td>"+arbitro.pontos+"</td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {

    }
}