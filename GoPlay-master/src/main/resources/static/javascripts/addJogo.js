
window.onload = async function() {
    try {
        let jogadores = await $.ajax({
            url: "/jogador",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let jogador of jogadores) {
            html+= "<option value="+jogador.id+">"+jogador.username+
                "</option>";
        }
        document.getElementById("jogador").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }
}


async function addJogo() {
    try {
        let album = {
            title: document.getElementById("title").value,
            artist: { id: parseInt(document.getElementById("jogador").value) }
        }
        console.log(JSON.stringify(album));
        let result = await $.ajax({
            url: "/jogo",
            method: "post",
            dataType: "json",
            data:JSON.stringify(album),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("Jogo_Id",result.id);
        window.location = "jogo.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}