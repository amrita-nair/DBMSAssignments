const mongoose = require('mongoose');
const studentSchema = require
('../models/student.schema.server');
// const studentModel = mongoose.model
// ('StudentModel', studentSchema);
// module.exports(studentModel);
module.exports = mongoose.model('StudentModel', studentSchema)