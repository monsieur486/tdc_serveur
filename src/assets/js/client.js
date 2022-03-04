window.addEventListener( "load", function( event ) {

    let ws = new WebSocket( "ws://localhost:8887/");

    function traitement(obj) {
        if (obj.code === 100) {
            alert( "Page rechargée par ping" );
            location.reload();
        }
    }

    ws.addEventListener( "open", function( evt ) {
        console.log( "Connecté au serveur websocket TDC" );
    });

    ws.addEventListener( "message", function( evt ) {
        let obj = JSON.parse(evt.data);
        traitement(obj);
    });

    ws.addEventListener( "close", function( evt ) {
        console.log( "Connexion avec le serveur websocket TDC interrompue." );
    });

});
