const mongoose = require('mongoose');
const questionSchema = require
('../models/question.schema.server');
// const questionModel = mongoose.model
// ('QuestionModel', questionSchema);
// module.exports(questionModel);
module.exports = mongoose.model('QuestionModel', questionSchema)