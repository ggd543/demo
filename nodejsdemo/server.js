var http = require('http');
http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World\n');
}).listen(8124, "0.0.0.0");
console.log(__filename);
console.log(__dirname);
console.log('Server running at http://0.0.0.0:8124/');