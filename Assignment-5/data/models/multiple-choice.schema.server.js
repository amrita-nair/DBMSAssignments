const mongoose = require('mongoose');
const multipleChoiceSchema = mongoose.Schema({
    choices: String,
    correct: Number
}, {collection: 'multipleChoice'});
module.exports = multipleChoiceSchema;