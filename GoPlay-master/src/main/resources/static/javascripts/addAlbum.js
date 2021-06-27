
window.onload = async function() {
    try {
        let artistas = await $.ajax({
            url: "/api/artists",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let artista of artistas) {
            html+= "<option value="+artista.id+">"+artista.name+
                "</option>";
        }
        document.getElementById("artist").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }
}


async function addAlbum() {
    try {
        let album = {
            title: document.getElementById("title").value,
            artist: { id: parseInt(document.getElementById("artist").value) }
        }
        console.log(JSON.stringify(album));
        let result = await $.ajax({
            url: "/api/albums",
            method: "post",
            dataType: "json",
            data:JSON.stringify(album),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("albumId",result.id);
        window.location = "album.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}