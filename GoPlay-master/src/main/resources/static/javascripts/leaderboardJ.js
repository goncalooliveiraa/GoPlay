

window.onload = function() {
    loadJogadores();
}

async function loadJogadores() {
    try {
        let jogadores = await $.ajax({
            url: "/api/jogadores/leaderboardJ",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("jogadores");
        let html = "";
        for (const jogador of jogadores) {
            html+="<tr><td>"+jogador.nome + " "+jogador.apelido +"</td>"+
            "<td>"+jogador.pontos+"</td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {
        // Tratar do erro depois
        /*
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";*/
                
    }
}

/*
window.onload = async function() {
    try {
        let Jogadores = await $.ajax({
            url:"/leaderboard",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let Jogador of Jogadores) {
            html+=`<section onclick = 'openJogadores(${Jogador.id})'>
                    <h2>${Jogador.Jog_NomeP}</h>
                    <h2>${Jogador.Jog_NomeA}</h>
                    <h2>${Jogador.Jog_Pontos}</h>

                    </section>`
        }
        document.getElementById("Jogadores").innerHTML = html;
    } catch(err) {
        console.log(err);
    }

}*/
