async function addInscricao() {
    try {
        let inscricao = {
            nome: document.getElementById("nome").value,
            apelido: document.getElementById("apelido").value,
            data: document.getElementById("data").value
        }
        console.log(JSON.stringify(inscricao));
        let result = await $.ajax({
            url: "/api/torneios",
            method: "post",
            dataType: "json",
            data:JSON.stringify(inscricao),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("Torn_Id",result.id);
        window.location = "inscritosT.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}