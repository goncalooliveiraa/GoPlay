window.onload = async function() {
    try {
        let torneios = await $.ajax({
            url: "/api/torneios",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let torneio of torneios) {
            html+= "<option value="+torneio.id+">"+torneio.data+
                "</option>";
        }
        document.getElementById("torneio").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }
}


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