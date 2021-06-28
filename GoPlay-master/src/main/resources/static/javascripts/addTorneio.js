async function addTorneio() {
    try {
        let torneio = {
            data: document.getElementById("data").value,
            local: document.getElementById("local").value,
            tipoJogo: document.getElementById("tipoJogo").value,
            numMax: document.getElementById("numMax").value
        }
        console.log(JSON.stringify(torneio));
        let result = await $.ajax({
            url: "/api/torneio",
            method: "post",
            dataType: "json",
            data:JSON.stringify(jogo),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("Torn_Id",result.id);
        window.location = "torneio.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}