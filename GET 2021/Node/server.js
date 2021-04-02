const http = require('http');

const server = http.createServer((req, res) => {
    res.end("Hi. Server is working properly.");
});

server.listen(5000, () => {
    console.log("Listening on Port 5000");
});