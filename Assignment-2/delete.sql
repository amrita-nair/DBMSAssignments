-- Delete Alices primary address

Delete from address where address.primary=1 and person_id= (select p_id from person where first_name='Alice');



--  Delete widget - Remove the last widget in the Contact page. The last widget is
 -- the one with the highest value in the order field
set @max_value= (select max(widget.order) from widget where  page_id=( select page_id from page where title='Contact'));
delete from widget where  
page_id=( select page_id from page where title='Contact')
and widget.order = @max_value;


-- Delete page - Remove the last updated page in Wikipedia
set @last_updated=(select max(updated) from page);
delete from page where updated=@last_updated and website_id=
(select website_id from website where website_name='Wikipedia');



-- Delete website - Remove the CNET web site, as well as all related roles
-- and privileges relating developers to the Website and Pages
Delete  from website where website_name='CNET' and website_id='567';
