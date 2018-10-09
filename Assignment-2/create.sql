Drop table address;
Drop table page_privilege;
Drop table page_role;
Drop table website_privilege;
Drop table website_role;
Drop table widget;
Drop table phone;
Drop table privilege;
Drop table role;
Drop table page;
Drop table website;
Drop table developer;
Drop table user;
Drop table person;

-- create person
CREATE TABLE `person` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `username_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;


-- create developer
CREATE TABLE `developer` (
  `p_id` int(11) NOT NULL,
  `developer_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `p_id_idx` (`p_id`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`p_id`) REFERENCES `person` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- create user
CREATE TABLE `user` (
  `p_id` int(11) NOT NULL,
  `user_agreement` tinyint(1) DEFAULT NULL,
  KEY `user_person_generalization_idx` (`p_id`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`p_id`) REFERENCES `person` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- create phone
CREATE TABLE `phone` (
  `person_id` int(11) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  KEY `phone_person_composition_idx` (`person_id`),
  CONSTRAINT `phone_person_composition` FOREIGN KEY (`person_id`) REFERENCES `person` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



-- create address
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `street1` varchar(45) NOT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) NOT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_person_composition` (`person_id`),
  CONSTRAINT `address_person_composition` FOREIGN KEY (`person_id`) REFERENCES `person` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


-- create website
CREATE TABLE `website` (
  `website_id` int(11) NOT NULL AUTO_INCREMENT,
  `website_name` varchar(45) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  PRIMARY KEY (`website_id`)
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=latin1;


-- create page
CREATE TABLE `page` (
  `page_id` int(11) NOT NULL AUTO_INCREMENT,
  `website_id` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `page_description` varchar(150) DEFAULT NULL,
  `created` varchar(45) DEFAULT NULL,
  `updated` varchar(45) DEFAULT NULL,
  `views` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`page_id`),
  KEY `page_website_composition_idx` (`website_id`),
  CONSTRAINT `page_website_composition` FOREIGN KEY (`website_id`) REFERENCES `website` (`website_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=568 DEFAULT CHARSET=latin1;



-- create widget
CREATE TABLE `widget` (
  `widget_id` int(11) NOT NULL AUTO_INCREMENT,
  `widget_name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `css_class` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareable` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `widgetcol` varchar(45) DEFAULT NULL,
  `dtype` enum('WIDGET','HEADING','HTML','YOUTUBE','IMAGE') DEFAULT NULL,
  `page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`widget_id`),
  KEY `widget_page_composition_idx` (`page_id`),
  CONSTRAINT `widget_page_composition` FOREIGN KEY (`page_id`) REFERENCES `page` (`page_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=latin1;


-- create Privilege
CREATE TABLE `privilege` (
  `privilege_name` varchar(20) NOT NULL,
  PRIMARY KEY (`privilege_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- create Role
CREATE TABLE `role` (
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- create website_role
CREATE TABLE `website_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developer_id` int(11) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `website_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_test_idx` (`role_name`),
  KEY `website_role_developer_association_idx` (`developer_id`),
  KEY `website_role_website_association_idx` (`website_id`),
  CONSTRAINT `website_role_developer_association` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `website_role_role_enum` FOREIGN KEY (`role_name`) REFERENCES `role` (`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_role_website_association` FOREIGN KEY (`website_id`) REFERENCES `website` (`website_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- create website_privilege
CREATE TABLE `website_privilege` (
  `privilege_name` varchar(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `website_id` int(11) DEFAULT NULL,
  `developer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_privilege_developer_association_idx` (`developer_id`),
  KEY `website_privilege_website_association_idx` (`website_id`),
  KEY `website_privilege_privilege_enum_idx` (`privilege_name`),
  CONSTRAINT `website_privilege_developer_association` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_privilege_privilege_enum` FOREIGN KEY (`privilege_name`) REFERENCES `privilege` (`privilege_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `website_privilege_website_association` FOREIGN KEY (`website_id`) REFERENCES `website` (`website_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;


-- create page_role
CREATE TABLE `page_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` int(11) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `developer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_role_page_association_idx` (`page_id`),
  KEY `page_role_developer_association_idx` (`developer_id`),
  KEY `page_role_role_enum_idx` (`role`),
  CONSTRAINT `page_role_developer_association` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `page_role_page_association` FOREIGN KEY (`page_id`) REFERENCES `page` (`page_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `page_role_role_enum` FOREIGN KEY (`role`) REFERENCES `role` (`role_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;



-- create page_privilege
CREATE TABLE `page_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` int(11) DEFAULT NULL,
  `privilege` varchar(45) DEFAULT NULL,
  `developer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_privilege_page_association_idx` (`page_id`),
  KEY `page_privilege_developer_association_idx` (`developer_id`),
  KEY `page_privilege_privilege_enum_idx` (`privilege`),
  CONSTRAINT `page_privilege_developer_association` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `page_privilege_page_association` FOREIGN KEY (`page_id`) REFERENCES `page` (`page_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `page_privilege_privilege_enum` FOREIGN KEY (`privilege`) REFERENCES `privilege` (`privilege_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;
