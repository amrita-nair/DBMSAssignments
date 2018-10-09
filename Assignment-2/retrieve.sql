-- Retrieve all developers
select * from developer d
left join person p
on d.p_id=p.p_id  ;

-- Retrieve a developer with id equal to 34 (charlie)
select d.p_id,user_name,first_name,last_name,email from developer d
left join person p
on d.p_id=p.p_id  
where d.p_id=34;

-- Retrieve all developers who have a role in Twitter other than owner (charlie, alice)
select d.p_id,user_name,first_name,last_name,email from developer d
left join person p
on d.p_id=p.p_id  
where d.p_id in (select developer_id from website w, website_role wr 
where wr.website_id=w.website_id and wr.website_id=234 and wr.role_name !='owner'   );

-- Retrieve all developers who are page reviewers of pages with less than 300000 visits (charlie, bob)
select d.p_id,user_name,first_name,last_name,email from developer d
left join person p
on p.p_id=d.p_id  
where d.p_id in (select developer_id from page p, page_role pr 
where pr.page_id=p.page_id and p.views < 300000 and pr.role = 'Reviewer'  );


-- Retrieve the writer developer who added a heading widget to CNETs home page (charlie)

select d.p_id,user_name,first_name,last_name,email from developer d
left join person p
on p.p_id=d.p_id  
where d.p_id in( select developer_id from page p, page_role pr 
where pr.page_id=p.page_id and pr.role = 'Writer' and p.website_id=567 and p.page_id=123);


-- Retrieve the website with the least number of visits

select * from page where views= (select min(views) from page);

-- Retrieve the name of a website whose id is 678 (Gizmodo)
select website_name from website where website_id=678;

-- Retrieve all websites with videos reviewed by bob (CNN)
Select website_name from website where website_id =(select website_id from page p, page_role pr,widget w
where pr.page_id=p.page_id and pr.page_id= w.page_id and p.page_id = w.page_id and pr.role = 'Reviewer' and pr.developer_id = (select p_id from person where first_name='bob')
and w.widget_id=678);


-- Retrieve all websites where alice is an owner (Facebook, )
Select website_name from website where website_id in(select website_id from website_role
where role_name = 'Owner' and developer_id in (select p_id from person where first_name='alice')
);


-- Retrieve all websites where charlie is an admin and get more than 6000000 visits

Select website_name from website where website_id in(select website_id from website_role
where role_name = 'Admin' and visits > 6000000 and developer_id in (select p_id from person where first_name='charlie')
);


-- Retrieve the page with the most number of views

select * from page where views=(select max(views) from page);

-- Retrieve the title of a page whose id is 234
select title from page where page_id=234;

-- Retrieve all pages where alice is an editor (About)
Select title from page where page_id in(select page_id from page_role
where role = 'Editor' and developer_id in (select p_id from person where first_name='alice')
);

-- Retrieve the total number of pageviews in CNET
select sum(views) from page where website_id in (select website_id from website where website_name='CNET');

-- Retrieve the average number of page views in the Web site Wikipedia
select avg(views) from page where website_id in (select website_id from website where website_name='Wikipedia');

-- Retrieve all widgets in CNETs Home page
select widget_id,widget_name,text,dtype,page_id from widget where page_id=(select page_id from page 
where title='Home' and website_id =(select website_id from website where website_name='CNET' ));

-- Retrieve all youtube widgets in CNN
select widget_id,widget_name,dtype,page_id from widget 
where dtype='youtube' and page_id=(select page_id from page 
where website_id =(select website_id from website where website_name='CNN' ));

-- Retrieve all image widgets on pages reviewed by Alice
select widget_id,widget_name,dtype,page_id from widget 
where dtype='image' and page_id=(select page_id from page_role
where role = 'Reviewer' and developer_id in (select p_id from person where first_name='alice'));


-- Retrieve how many widgets are in Wikipedia

select count(widget_id) from widget where page_id =
(select page_id from  page where website_id in
(select website_id from website where website_name='Wikipedia'));



-- Retrieve the names of all the websites where Bob has DELETE privileges.
 -- Answer: Twitter, Wikipedia, CNET, Gizmodo (where Bob has either owner or admin roles).
 select website_name from website where website_id in(
 select website_id from website_privilege where privilege_name='Delete' and developer_id=
 (select p_id from person where first_name='bob'));
 
 
-- Retrieve the names of all the pages where Charlie has CREATE privileges. 
-- Answer: Home, Preferences (where Charlie has Writer role)

 select title from page where page_id in(
 select page_id from page_privilege where privilege='Create' and developer_id=
 (select p_id from person where user_name='Charlie'));