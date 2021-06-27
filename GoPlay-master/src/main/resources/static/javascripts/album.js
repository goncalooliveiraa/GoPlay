

window.onload = async function() {
    let albumId = sessionStorage.getItem("albumId");
    try {
        
        let album = await $.ajax({
            url: "/api/albums/"+albumId,
            method: "get",
            dataType: "json"
        });
        console.log(album);
        //document.getElementById("cover").src = "/images/cover" + album.AlbumId + ".jpg";  
        
        
        //if (album.Cover != null) {
        //     document.getElementById("cover").src = album.Cover;
        //}
        

        document.getElementById("titulo").innerHTML = album.title;
        document.getElementById("artista").innerHTML = album.artist.name;


        let tracks = await $.ajax({
            url: "/api/albums/"+albumId+"/tracks",
            method: "get",
            dataType: "json"
        });

        
        let html = "";
        for(let track of tracks) {
            html+= "<p onclick='showTrack("+track.id+")'>"+track.name+" - "+track.price+" €</p>";
        }
        document.getElementById("tracks").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}


function showTrack(id) {
    // TODO: open page with track info
} 