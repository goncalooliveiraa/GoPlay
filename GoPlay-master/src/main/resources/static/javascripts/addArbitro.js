
async function addArbitro() {
    try {
        let arbitro = {
            nome: document.getElementById("nome").value,
            nascimento: document.getElementById("nascimento").value 
        }
        console.log(JSON.stringify(arbitro));
        let result = await $.ajax({
            url: "/api/arbitros",
            method: "post",
            dataType: "json",
            data:JSON.stringify(arbitro),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("id",result.id);
        window.location = "leaderboardA.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}