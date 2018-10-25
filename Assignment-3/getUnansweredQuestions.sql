DELIMITER $$
CREATE DEFINER=`amritanair`@`%` PROCEDURE `getUnansweredQuestions`()
BEGIN
DECLARE COUNT INT;
 select count(a.answer_id) into COUNT FROM Answer group by a.question_id;
  select
  q.question_id,
  q.text, COUNT
from
  Question q,
  Answer a
where
  q.question_id = a.question_id
  and a.correctAnswer = false
  and COUNT =(
    Select
      max(COUNT) from COUNT)
group by
  q.module;
END$$
DELIMITER ;
