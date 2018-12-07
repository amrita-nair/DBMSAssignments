const mongoose = require('mongoose');
const trueFalseSchema = mongoose.Schema({
    isTrue: Boolean
}, {collection: 'trueFalse'});
module.exports = trueFalseSchema;