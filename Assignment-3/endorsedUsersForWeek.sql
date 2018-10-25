DELIMITER $$
CREATE DEFINER=`amritanair`@`%` PROCEDURE `endorsedUsersForWeek`(IN d1 Date, IN d2 Date)
BEGIN
DECLARE COUNT INT;
 select count(a.answer_id) into COUNT FROM Answer where a.correctAnswer=true and 
 a.posted_on BETWEEN d1 AND d2 group by a.posted_by;

SELECT a.posted_by,u.user_Id
FROM answer a,user u
WHERE a.userId=u.userId 
and
a.posted_by in

  (
    SELECT TOP (5) 
    FROM COUNT 
    ORDER BY a.posted_by DESC
  );

END$$
DELIMITER ;
