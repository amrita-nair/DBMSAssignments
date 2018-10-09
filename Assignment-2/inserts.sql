-- Insert Statements

INSERT INTO `cs5200_fall2018_A2_amritanair`.`person`
(`p_id`,
`first_name`,
`last_name`,
`user_name`,
`password`,
`email`)
VALUES
(23,
'Bob',
'Marley',
'bob',
'bob',
'bob@marley.com');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`person`
(`p_id`,
`first_name`,
`last_name`,
`user_name`,
`password`,
`email`)
VALUES
(34,
'Charles',
'Garcia',
'charlie',
'charlie',
'chuch@garcia.com');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`person`
(`p_id`,
`first_name`,
`last_name`,
`user_name`,
`password`,
`email`)
VALUES
(45,
'Dan',
'Martin',
'dan',
'dan',
'dan@martin.com');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`person`
(`p_id`,
`first_name`,
`last_name`,
`user_name`,
`password`,
`email`)
VALUES
(56,
'Ed',
'Karaz',
'ed',
'ed',
'ed@kar.com');



INSERT INTO `cs5200_fall2018_A2_amritanair`.`developer`
(`p_id`,
`developer_key`)
VALUES
(12,
'4321rewq');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`developer`
(`p_id`,
`developer_key`)
VALUES
(23,
'5432trew');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`developer`
(`p_id`,
`developer_key`)
VALUES
(34,
'6543ytre');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`user`
(`p_id`,
`user_agreement`)
VALUES
(45,
'7654fda');

INSERT INTO `cs5200_fall2018_A2_amritanair`.`user`
(`p_id`,
`user_agreement`)
VALUES
(56,
'5678dfgh');


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website`
(`website_id`,
`website_name`,
`description`,
`created`,
`updated`,
`visits`)
VALUES
(123,
'Facebook',
'an online social media and social networking service',
current_date ,
current_date ,
1234234);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website`
(`website_id`,
`website_name`,
`description`,
`created`,
`updated`,
`visits`)
VALUES
(234,
'Twitter',
'an online news and social networking service',
current_date ,
current_date ,
4321543);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website`
(`website_id`,
`website_name`,
`description`,
`created`,
`updated`,
`visits`)
VALUES
(345,
'Wikipedia',
'a free online encyclopedia',
current_date ,
current_date ,
3456654);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website`
(`website_id`,
`website_name`,
`description`,
`created`,
`updated`,
`visits`)
VALUES
(456,
'CNN',
'an American basic cable and satellite television news channel',
current_date ,
current_date ,
6543345);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website`
(`website_id`,
`website_name`,
`description`,
`created`,
`updated`,
`visits`)
VALUES
(567,
'CNET',
'an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics',
current_date ,
current_date ,
5433455);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website`
(`website_id`,
`website_name`,
`description`,
`created`,
`updated`,
`visits`)
VALUES
(678,
'Gizmodo',
'a design, technology, science and science fiction website that also writes articles on politics',
current_date ,
current_date ,
4322345);



INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(12,
'Owner',
123);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(23,
'editor',
123);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(34,
'admin',
123);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(23,
'Owner',
234);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(34,
'editor',
234);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(12,
'admin',
234);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(34,
'Owner',
345);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(12,
'editor',
345);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(23,
'admin',
345);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(12,
'Owner',
456);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(23,
'editor',
456);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(34,
'admin',
456);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(23,
'Owner',
567);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(34,
'editor',
567);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(12,
'admin',
567);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(34,
'Owner',
678);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(12,
'editor',
678);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`website_role`
(
`developer_id`,
`role_name`,
`website_id`)
VALUES
(23,
'admin',
678);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page`
(`page_id`,
`website_id`,
`title`,
`page_description`,
`created`,
`updated`,
`views`)
VALUES
(123,
567,
'Home',
'Landing page',
'2018-09-05',
'2018-10-08',
123434);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page`
(`page_id`,
`website_id`,
`title`,
`page_description`,
`created`,
`updated`,
`views`)
VALUES
(234,
678,
'About',
'Website description',
'2018-09-05',
'2018-10-08',
234545);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page`
(`page_id`,
`website_id`,
`title`,
`page_description`,
`created`,
`updated`,
`views`)
VALUES
(345,
345,
'Contact',
'Addresses, phones, and contact info',
'2018-09-05',
'2018-10-08',
345656);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page`
(`page_id`,
`website_id`,
`title`,
`page_description`,
`created`,
`updated`,
`views`)
VALUES
(456,
456,
'Preferences',
'Where users can configure their preferences',
'2018-09-05',
'2018-10-08',
456776);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page`
(`page_id`,
`website_id`,
`title`,
`page_description`,
`created`,
`updated`,
`views`)
VALUES
(567,
567,
'Profile',
'Users can configure their personal information',
'2018-09-05',
'2018-10-08',
567878);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(12,
'editor',
123);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(23,
'reviewer',
123);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(34,
'writer',
123);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(23,
'editor',
234);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(34,
'reviewer',
234);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(12,
'writer',
234);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(34,
'editor',
345);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(12,
'reviewer',
345);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(23,
'writer',
345);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(12,
'editor',
456);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(23,
'reviewer',
456);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(34,
'writer',
456);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(23,
'editor',
567);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(34,
'reviewer',
567);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`page_role`
(
`developer_id`,
`role`,
`page_id`)
VALUES
(12,
'writer',
567);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`widget`
(`widget_id`,
`widget_name`,
`width`,
`height`,
`css_class`,
`text`,
`order`,
`url`,
`shareable`,
`expandable`,
`src`,
`size`,
`widgetcol`,
`dtype`,
`page_id`)
VALUES
(123,
'head123',
null,
null,
null,
'Welcome',
0,
null,
null,
null,
null,
null,
null,
'heading',
123);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`widget`
(`widget_id`,
`widget_name`,
`width`,
`height`,
`css_class`,
`text`,
`order`,
`url`,
`shareable`,
`expandable`,
`src`,
`size`,
`widgetcol`,
`dtype`,
`page_id`)
VALUES
(234,
'post234',
null,
null,
null,
'<p>Lorem</p>',
0,
null,
null,
null,
null,
null,
null,
'html',
234);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`widget`
(`widget_id`,
`widget_name`,
`width`,
`height`,
`css_class`,
`text`,
`order`,
`url`,
`shareable`,
`expandable`,
`src`,
`size`,
`widgetcol`,
`dtype`,
`page_id`)
VALUES
(345,
'head345',
null,
null,
null,
'Hi',
1,
null,
null,
null,
null,
null,
null,
'heading',
345);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`widget`
(`widget_id`,
`widget_name`,
`width`,
`height`,
`css_class`,
`text`,
`order`,
`url`,
`shareable`,
`expandable`,
`src`,
`size`,
`widgetcol`,
`dtype`,
`page_id`)
VALUES
(456,
'intro456',
null,
null,
null,
'<h1>Hi</h1>',
0,
null,
null,
null,
null,
null,
null,
'html',
345);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`widget`
(`widget_id`,
`widget_name`,
`width`,
`height`,
`css_class`,
`text`,
`order`,
`url`,
`shareable`,
`expandable`,
`src`,
`size`,
`widgetcol`,
`dtype`,
`page_id`)
VALUES
(567,
'image345',
50,
100,
null,
null,
3,
'/img/567.png',
null,
null,
null,
null,
null,
'image',
345);



INSERT INTO `cs5200_fall2018_A2_amritanair`.`widget`
(`widget_id`,
`widget_name`,
`width`,
`height`,
`css_class`,
`text`,
`order`,
`url`,
`shareable`,
`expandable`,
`src`,
`size`,
`widgetcol`,
`dtype`,
`page_id`)
VALUES
(678,
'video456',
400,
300,
null,
null,
0,
'https://youtu.be/h67VX51QXiQ',
null,
null,
null,
null,
null,
'youtube',
456);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`phone`
(`person_id`,
`phone`,
`primary`)
VALUES
(12,
'123-234-3456',
1);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`phone`
(`person_id`,
`phone`,
`primary`)
VALUES
(12,
'234-345-4566',
0);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`phone`
(`person_id`,
`phone`,
`primary`)
VALUES
(23,
'345-456-5677',
1);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`phone`
(`person_id`,
`phone`,
`primary`)
VALUES
(34,
'321-432-5435',
1);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`phone`
(`person_id`,
`phone`,
`primary`)
VALUES
(34,
'432-432-5433',
0);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`phone`
(`person_id`,
`phone`,
`primary`)
VALUES
(34,
'432-432-5433',
0);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`address`
(
`person_id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`)
VALUES
(
12,
'123 Adam St',
null,
'Alton',
null,
01234,
1);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`address`
(
`person_id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`)
VALUES
(
12,
'234 Birch St',
null,
'Boston',
null,
02345,
0);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`address`
(
`person_id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`)
VALUES
(
23,
'345 Charles St',
null,
'Chelms',
null,
03455,
1);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`address`
(
`person_id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`)
VALUES
(
23,
'456 Down St.',
null,
'Dalton',
null,
04566,
0);

INSERT INTO `cs5200_fall2018_A2_amritanair`.`address`
(
`person_id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`)
VALUES
(
23,
'543 East St.',
null,
'Everett',
null,
01112,
0);


INSERT INTO `cs5200_fall2018_A2_amritanair`.`address`
(
`person_id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`)
VALUES
(
34,
'654 Frank St.',
null,
'Foulton',
null,
04322,
1);