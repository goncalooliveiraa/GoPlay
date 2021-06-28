window.onload = async function() {
    let Torn_Id = sessionStorage.getItem("Torn_Id");
    try {
        
        let jogadores = await $.ajax({
            url: "/api/torneios",
            method: "get",
            dataType: "json"
        });
        console.log(torneio);

        document.getElementById("nome").innerHTML = torneio.nome;
        document.getElementById("apelido").innerHTML = torneio.apelido;
        document.getElementById("data").innerHTML = torneio.data;


        let inscricoes = await $.ajax({
            url: "/api/torneios/"+Torn_Id+"/inscricoes",
            method: "get",
            dataType: "json"
        });

        
        let html = "";
        for(let inscricao of inscricoes) {
            html+= "<p onclick='showInscricoes("+inscricao.id+")'>"+inscricao.nome+" + "+inscricao.apelido+" + "+inscricao.data+" </p>";
        }
        document.getElementById("inscricoes").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}

function showInscricoes(id) {} 