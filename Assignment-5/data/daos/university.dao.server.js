// const mongoose = require('mongoose');
// const studentSchema = require
// ('../models/student.schema.server');
// const questionSchema = require
// ('../models/question.schema.server');
// const answerSchema = require
// ('../models/answer.schema.server');
// const studentModel = mongoose.model
// ('StudentModel', studentSchema);
// const questionModel = mongoose.model
// ('QuestionModel', questionSchema);
// const answerModel = mongoose.model
// ('AnswerModel', answerSchema);

const studentModel = require('../models/student.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');

truncateDatabase = () => Promise.all([
    studentModel.deleteMany({}),
    questionModel.deleteMany({}),
    answerModel.deleteMany({})
]);

populateDatabase = () => Promise.all([
    ...students.map(student => createStudent(student)),
    ...questions.map(question => createQuestion(question)),
    ...answers.map(answer => answerQuestion(answer))
]);

createStudent = (student) =>
    studentModel.create(student);

deleteStudent = studentId =>
    studentModel.remove({_id: studentId});

createQuestion = (question) =>
    questionModel.create(question);

deleteQuestion = questionId =>
    questionModel.remove({_id: questionId});

answerQuestion = (answer) =>
    answerModel.create(answer);

deleteAnswer = answerId =>
    answerModel.remove({_id: answerId});


findAllStudents = () =>
    studentModel.find();

findStudentById = studentId =>
    studentModel.findById(studentId);

findAllQuestions = () =>
    questionModel.find();

findQuestionById = questionId =>
    questionModel.findById(questionId);

findAllAnswers = () =>
    answerModel.find();

findAnswerById = answerId =>
    answerModel.findById(answerId);

findAnswersByStudent = studentId =>
    answerModel.find({student: studentId});

findAnswersByQuestion = questionId =>
    answerModel.find({question: questionId});

deleteMultipleChoiceAnswersByStudent = (studentId, question) =>
    answerModel.deleteMany({student: studentId, question: 'What does ORM stand for?'});

const students = [
    {
        _id: 123,
        username: 'alice',
        password: 'alice',
        firstName: 'Alice',
        lastName: 'Wonderland',
        gradYear: 2020,
        scholarship: 15000
    },
    {
        _id: 234, username: 'bob', password: 'bob', firstName: 'Bob', lastName: 'Hope',
        gradYear: 2021, scholarship: 12000
    }
];

const questions = [{
    _id: 321, question: 'Is the following schema valid?', points: 10,
    questionType: 'TRUE_FALSE', trueFalse: {isTrue: false}
}, {
    _id: 432, question: 'DAO stands for Dynamic Access Object.', points: 10,
    questionType: 'TRUE_FALSE', trueFalse: {isTrue: false}
}, {
    _id: 543, question: 'What does JPA stand for?', points: 10,
    questionType: 'MULTIPLE_CHOICE', multipleChoice:
        {
            choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
            correct: 1
        }
}, {
    _id: 654, question: 'What does ORM stand for?', points: 10,
    questionType: 'MULTIPLE_CHOICE', multipleChoice:
        {
            choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
            correct: 4
        }
}];

const answers = [{
    _id: 123, trueFalseAnswer: true, multipleChoiceAnswer: null,
    student: 123, question: 321
}, {
    _id: 234, trueFalseAnswer: false, multipleChoiceAnswer: null,
    student: 123, question: 432
}, {
    _id: 345, trueFalseAnswer: null, multipleChoiceAnswer: 1,
    student: 123, question: 543
}, {
    _id: 456, trueFalseAnswer: null, multipleChoiceAnswer: 2,
    student: 123, question: 654
}, {
    _id: 567, trueFalseAnswer: false, multipleChoiceAnswer: null,
    student: 234, question: 321
}, {
    _id: 678, trueFalseAnswer: true, multipleChoiceAnswer: null,
    student: 234, question: 432
}, {
    _id: 789, trueFalseAnswer: null, multipleChoiceAnswer: 3,
    student: 234, question: 543
}, {
    _id: 890, trueFalseAnswer: null, multipleChoiceAnswer: 4,
    student: 234, question: 654
}];

module.exports = {
    findAnswersByStudent,
    deleteMultipleChoiceAnswersByStudent,
    populateDatabase,
    findAllStudents,
    createStudent,
    findStudentById,
    deleteStudent,
    createQuestion,
    answerQuestion,
    truncateDatabase,
    findAllQuestions,
    findAllAnswers,
    deleteQuestion
};