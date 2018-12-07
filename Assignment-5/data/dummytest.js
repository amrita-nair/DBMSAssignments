require('./db')();
var universityDao = require('./daos/university.dao.server');
universityDao.truncateDatabase()
    .then(students =>
        console.log(students)).catch((err) => {

});
// universityDao.deleteStudent(123).then(students =>
//     console.log(students)).catch((err) => {
//
// });
// universityDao.deleteStudent(234).then(students =>
//     console.log(students)).catch((err) => {
//
// });
// universityDao.findAllStudents()
//     .then(students =>
//         console.log(students)).catch((err) => {
//
// });
// universityDao.populateDatabase()
//     .then(result =>
//         console.log(result)).catch((err) => {
//
// });
// universityDao.createStudent({_id: 123, username: 'alice', password: 'alice', firstName: 'Alice', lastName: 'Wonderland',
//     gradYear : 2020, scholarship: 15000}).then(newStudent =>
//     console.log(newStudent));

// universityDao.createQuestion({_id: 543, question: 'What does JPA stand for?', points: 10,
//     questionType: 'MULTIPLE_CHOICE', multipleChoice:
//         {choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
//             correct: 1}}).then(newQuestion =>
//     console.log(newQuestion));

// universityDao.answerQuestion({_id:123, trueFalseAnswer: true, multipleChoiceAnswer: null,
//     student: 123, question: 321}).then(newAnswer =>
//     console.log(newAnswer));

