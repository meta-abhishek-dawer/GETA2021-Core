const express = require('express');
const path = require('path');
const app = express();

staticPath = path.join(__dirname, '/UI');
console.log(staticPath);
app.use(express.static(staticPath));

const port = 5000;

app.listen(port, () => {console.log(`listeining on the port ${port}`)});
