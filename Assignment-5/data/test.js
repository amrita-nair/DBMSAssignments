require('./db')();
const assert = require('assert');
const uniDao = require('./daos/university.dao.server');
const assertEquals = (actual, expected) => {
    assert.strictEqual(actual, expected, 'This is a helpful error message');
};

const truncateDatabase = uniDao.truncateDatabase;
const populateDatabase = uniDao.populateDatabase;
var testStudentsInitialCount = num => {
    uniDao.findAllStudents()
        .then(res => {
            assertEquals(res.length, num);
        })
        .then(() => console.log("success."))
}
var testQuestionsInitialCount = num => {
    uniDao.findAllQuestions()
        .then(res => {
            assertEquals(res.length, num);
        })
        .then(() => console.log("success."))
}
var testAnswersInitialCount = num => {
    uniDao.findAllAnswers()
        .then(res => {
            assertEquals(res.length, num);
        })
        .then(() => console.log("success."))
}
var testDeleteAnswer = () => {
    uniDao.deleteMultipleChoiceAnswersByStudent(234,'What does ORM stand for?')
        .then(res => {
            testAnswersInitialCount(7);
        })
        .then(() => console.log("success."))
}
var testDeleteQuestion = () => {
    uniDao.deleteQuestion(321)
        .then(res => {
            testQuestionsInitialCount(3);
        })
        .then(() => console.log("success."))
}
var testDeleteStudent = () => {
    uniDao.deleteStudent(234)
        .then(res => {
            testStudentsInitialCount(1);
        })
        .then(() => console.log("success."))
}


truncateDatabase().then(
    (res) => {
        populateDatabase().then(
            (res) => {
                testStudentsInitialCount(2)
                testQuestionsInitialCount(4)
                testAnswersInitialCount(8)
                testDeleteAnswer()
                testDeleteQuestion()
                testDeleteStudent()
            },
            (err) => console.log(err)
        )
    },
    (err) => console.log(err)
)