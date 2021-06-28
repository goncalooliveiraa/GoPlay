window.onload = async function() {
    try {
        let tipoJogos = await $.ajax({
            url: "/api/tipoJogo",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let tipoJogo of tipoJogos) {
            html+= "<option value="+tipoJogo.id+">"+tipoJogo.nome+
                "</option>";
        }
        document.getElementById("tipoJogo").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }
}

async function addJogo() {
    try {
        let jogo = {
            data: document.getElementById("data").value,
            local: document.getElementById("local").value,
            tipojogo: { id: parseInt(document.getElementById("tipojogo").value) }
        }
        console.log(JSON.stringify(jogo));
        let result = await $.ajax({
            url: "/api/jogo",
            method: "post",
            dataType: "json",
            data:JSON.stringify(jogo),
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