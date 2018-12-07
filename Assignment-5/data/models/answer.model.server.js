const mongoose = require('mongoose');
const answerSchema = require('../models/answer.schema.server');

module.exports = mongoose.model('AnswerModel', answerSchema)