
window.onload = async function() {
    let Torn_Id = sessionStorage.getItem("Torn_Id");
    try {
        
        let jogadores = await $.ajax({
            url: "/api/torneios",
            method: "get",
            dataType: "json"
        });
        console.log(torneio);
        //document.getElementById("cover").src = "/images/cover" + album.AlbumId + ".jpg";  
        
        
        //if (album.Cover != null) {
        //     document.getElementById("cover").src = album.Cover;
        //}
        

        document.getElementById("titulo").innerHTML = torneio.title;
        document.getElementById("nome").innerHTML = torneio.nome;


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


function showInscricoes(id) {
    // TODO: open page with track info
} 