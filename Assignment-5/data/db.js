module.exports = function () {
    const mongoose = require('mongoose');
    const databaseName = 'whiteboard';
    var connectionString = 'mongodb://localhost/';
    connectionString += databaseName;
    return mongoose.connect(connectionString, { useNewUrlParser: true });
};
