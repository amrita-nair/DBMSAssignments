 
 -- Update developer - Update Charlies primary phone number to 333-444-5555
Update phone 
set phone='333-444-5555' 
where `primary`=1 and person_id =
(select p_id from person where user_name='Charlie');

select * from phone where `primary`=1 and person_id =
(select p_id from person where user_name='Charlie');




-- Update widget - Update the relative order of widget head345 on the page 
-- so that it's new order is 3. Note that the other widget's order needs to update as well
set @x=(select widget.page_id 
from widget join page on widget.page_id=page.page_id 
where widget_name='head345' and 
title='Contact');


set @a= (select widget.widget_id 
from widget join page on widget.page_id=page.page_id 
where widget_name='head345' and 
title='Contact'); 
set @c= (select widget.widget_id 
from widget join page on widget.page_id=page.page_id 
where widget_name='head345' and 
title='Contact'); 
set @b= (select min(widget_id) from widget where widget.page_id= @a and widget_id!=@c);
set @d= (select max(widget_id) from widget where widget.page_id= @a and widget_id!=@c);


Update widget set widget.order =
CASE

WHEN (widget_id=@a)  then 
	 widget.order+2 
     
     
WHEN (widget_id = @b ) then 
	 widget.order-1
    

WHEN ( widget_id= @d) then
	 widget.order-1
    

END

WHERE widget.page_id= @x;
    
    
select widget.page_id ,widget.order,widget.widget_id
from widget join page on widget.page_id=page.page_id 
where  
title='Contact';


-- Update page - Append 'CNET - ' to the beginning of all CNETs page titles

Update page 
set title=concat('CNET - ',title) 
where website_id =
(select website_id from website where website_name='CNET');



-- Update roles - Swap Charlie's and Bob's role in CNETs Home page
 -- Update developer - Update Charlies primary phone number to 333-444-5555



set @bob_role= (select role from page_role where developer_id=(
    select p_id from person where user_name='Bob')
    and page_id=(
    select page_id from page where title='CNET - Home' and
    website_id=(
    select website_id from website where website_name ='CNET')));
set @Charlie_role= (select role from page_role where developer_id=(
    select p_id from person where user_name='Charlie')
    and page_id=(
    select page_id from page where title='CNET - Home' and
    website_id=(
    select website_id from website where website_name ='CNET')));

UPDATE page_role 
SET role = 
CASE
    WHEN role= @Charlie_role 
    
    THEN 
          @bob_role
    
    WHEN role = @bob_role
    
    THEN  @Charlie_role
    
END 

WHERE role IN (@Charlie_role,@Bob_role);