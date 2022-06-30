const socket = io("ws://127.0.0.1:4001");

// écoute du socket news
socket.on('FromAPI', function(code, value){
    console.log("Code: " + code + " value: " + value)
});
