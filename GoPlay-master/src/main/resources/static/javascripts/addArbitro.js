
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


async function addArbitro() {
    try {
        let arbitro = {
            nome: document.getElementById("nome").value,
            nascimento: document.getElementById("nascimento").value 
        }
        console.log(JSON.stringify(arbitro));
        let result = await $.ajax({
            url: "/jogo",
            method: "post",
            dataType: "json",
            data:JSON.stringify(arbitro),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("Arb_Id",result.id);
        window.location = "jogador.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}