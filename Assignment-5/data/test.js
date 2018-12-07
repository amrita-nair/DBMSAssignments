const assert = require('assert');
const assertEquals = (actual, expected) => {
    assert.strictEqual(actual, expected, 'Failed');
};

const connection = require('./db')()
var universityDao = require('./daos/university.dao.server');

universityDao.truncateDatabase()
    .then(() => universityDao.populateDatabase())
    .then(() => universityDao.findAllStudents())
    .then(students => assert(2, students.length))
    .then(() => universityDao.findAllQuestions())
    .then(questions => assert(4, questions.length))
    .then(() => universityDao.findAllAnswers())
    .then(answers => assert(8, answers.length))
    .then(universityDao.deleteMultipleChoiceAnswersByStudent(234, 'What does ORM stand for?')) // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
    .then(universityDao.findAllAnswers()
        .then(result =>
            assertEquals(result.length, 7)))
    .then(universityDao.deleteQuestion(321)) // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
    .then(universityDao.findAllQuestions()
        .then(result =>
            assertEquals(result.length, 3)))
    .then(universityDao.deleteStudent(234))// make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
    .then(universityDao.findAllStudents()
        .then(result => {
            assertEquals(result.length, 1)
                .then(() => console.log("Tests passed."))
        })).catch(err => console.log(err))
// universityDao.truncateDatabase()
//     .then(result => console.assert(result.size()==0, "Message to display if the test  fails")).catch((err) => {
//
// });


// const testTrucateDatabase = () => {
//     universityDao.truncateDatabase() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(result => {
//             assertEquals(result.length, 0); // the test
//         })
//         .then(() => handleSuccess()) // success
//         .catch(err => handleError(err)); // failure - use err.message to see the helpful message you made in assert
// };
//
// testTrucateDatabase();
//
//
// universityDao.populateDatabase()
//     .then(result =>
//         console.log(result)).catch((err) => {
//
// });
// //
// const testPopulateDatabase = () => {
//
//     universityDao.populateDatabase() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(result => {
//             assertEquals(result.length, 14); // the test
//         })
//         .then(() => handleSuccess()) // success
//         .catch(err => handleError(err)); // failure - use err.message to see the helpful message you made in assert
// };
//
// testPopulateDatabase();


////GOOD///
// const testStudentsInitialCount = () => {
//     universityDao.findAllStudents() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(result => {
//             assertEquals(result.length, 2); // the test
//         })
//         .then(() => console.log('Passed')) // success
//         .catch(err => console.log('testStudentsInitialCount ')); // failure - use err.message to see the helpful message you made in assert
// };
// testStudentsInitialCount();
//
// const testQuestionsInitialCount = () => {
//     universityDao.findAllQuestions() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(result => {
//             assertEquals(result.length, 4); // the test
//         })
//         .then(() => console.log('Passed')) // success
//         .catch(err => console.log('testQuestionsInitialCount')); // failure - use err.message to see the helpful message you made in assert
// };
// testQuestionsInitialCount();
//
// const testAnswersInitialCount = () => {
//     universityDao.findAllAnswers() // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(result => {
//             assertEquals(result.length, 8); // the test
//         })
//         .then(() => console.log('Passed')) // success
//         .catch(err => console.log('testAnswersInitialCount')); // failure - use err.message to see the helpful message you made in assert
// };
// testAnswersInitialCount();
//
//
// // testDeleteAnswer() - uses DAO to remove Bob’s answer for the multiple choice question
// // “What does ORM stand for?” and validates the total number of amswers is 7 and Bob’s total number of answers is 3
//
// // const testDeleteAnswer = () => {
// //     universityDao.deleteMultipleChoiceAnswersByStudent(234,'What does ORM stand for?') // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
// //         .then(universityDao.findAllAnswers().then
// //         (result => {assertEquals(result.length, 7); // the test
// //         }) .then(universityDao.findAnswersByStudent(234).then
// //         (result => {assertEquals(result.length, 3); // the test
// //         })
// //         .then(() => console.log('Passed')) // success
// //         .catch(err => console.log('failed due to '+err)))); // failure - use err.message to see the helpful message you made in assert
// // };
// // testDeleteAnswer();
//
// // deleteQuestion
// // testDeleteQuestion() - uses DAO to remove true false question “Is the following schema valid?”
// // and validates the total number of questions is 3
//
// const testDeleteQuestion = () => {
//     universityDao.deleteQuestion(321) // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(universityDao.findAllQuestions().then
//         (result => {assertEquals(result.length, 3); // the test
//         })
//             .then(() => console.log('Passed')) // success
//             .catch(err => console.log('testDeleteQuestion'))); // failure - use err.message to see the helpful message you made in assert
// };
// testDeleteQuestion();
//
// // testDeleteStudent() - uses DAO to remove student Bob and validates the total number of students is 1
//
// const testDeleteStudent = () => {
//     universityDao.deleteStudent(234) // make sure this calls .exec() or .then() can have slightly different behavior (typically it will be okay but this is consistent)
//         .then(universityDao.findAllStudents().then
//         (result => {assertEquals(result.length, 1); // the test
//         })
//             .then(() => console.log('Passed')) // success
//             .catch(err => console.log('testDeleteStudent'))); // failure - use err.message to see the helpful message you made in assert
// };
// testDeleteStudent();
//
//
// // universityDao.deleteStudent(123).then(students =>
// //     console.log(students)).catch((err) => {
// //
// // });
// // universityDao.deleteStudent(234).then(students =>
// //     console.log(students)).catch((err) => {
// //
// // });
// // universityDao.findAllStudents()
// //     .then(students =>
// //         console.log(students)).catch((err) => {
// //
// // });
//
// // universityDao.createStudent({_id: 123, username: 'alice', password: 'alice', firstName: 'Alice', lastName: 'Wonderland',
// //     gradYear : 2020, scholarship: 15000}).then(newStudent =>
// //     console.log(newStudent));
//
// // universityDao.createQuestion({_id: 543, question: 'What does JPA stand for?', points: 10,
// //     questionType: 'MULTIPLE_CHOICE', multipleChoice:
// //         {choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
// //             correct: 1}}).then(newQuestion =>
// //     console.log(newQuestion));
//
// universityDao.answerQuestion({_id:595, trueFalseAnswer: true, multipleChoiceAnswer: null}, 123, 321).then(newAnswer =>
//     console.log(newAnswer));

