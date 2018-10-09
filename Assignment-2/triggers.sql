DELIMITER $$
USE `cs5200_fall2018_A2_amritanair`$$
CREATE DEFINER=`amritanair`@`%` TRIGGER after_role_insert 
		AFTER INSERT ON website_role
		FOR EACH ROW 
	BEGIN
		
	IF NEW.role_name = 'owner' THEN
	INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'create',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'delete',NEW.website_Id,NEW.developer_Id);
	
    ELSEIF NEW.role_name = 'admin' THEN
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'create',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'delete',NEW.website_Id,NEW.developer_Id);
   
    ELSEIF NEW.role_name = 'writer' THEN
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'create',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);
   
    ELSEIF NEW.role_name = 'editor' THEN
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);
 
    ELSEIF NEW.role_name = 'reviewer' THEN
    
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
   
	END IF;

	end$$
DELIMITER ;


DELIMITER $$
USE `cs5200_fall2018_A2_amritanair`$$
CREATE DEFINER=`amritanair`@`%` TRIGGER after_role_update 
		AFTER UPDATE ON website_role
		FOR EACH ROW 
	BEGIN
   
    Delete from website_privilege where website_privilege.developer_id = OLD.developer_id and website_privilege.website_id = OLD.website_id;
    
	IF NEW.role_name = 'owner' THEN
	INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'create',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'delete',NEW.website_Id,NEW.developer_Id);
	
    ELSEIF NEW.role_name = 'admin' THEN
    
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'create',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'delete',NEW.website_Id,NEW.developer_Id);
 
    ELSEIF NEW.role_name = 'writer' THEN
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'create',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);

    ELSEIF NEW.role_name = 'editor' THEN
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'update',NEW.website_Id,NEW.developer_Id);

    ELSEIF NEW.role_name = 'reviewer' THEN
    INSERT INTO website_privilege (privilege_name,website_Id,developer_Id) VALUES ( 'read',NEW.website_Id,NEW.developer_Id);
    END IF;

	end$$
DELIMITER ;

DELIMITER $$
USE `cs5200_fall2018_A2_amritanair`$$
CREATE DEFINER=`amritanair`@`%` TRIGGER after_role_delete 
		AFTER DELETE ON website_role
		FOR EACH ROW 
	BEGIN
        Delete from website_privilege where website_privilege.developer_id = OLD.developer_id and website_privilege.website_id = OLD.website_id;
    
	end$$
DELIMITER ;


DELIMITER $$
USE `cs5200_fall2018_A2_amritanair`$$
CREATE DEFINER=`amritanair`@`%` TRIGGER after_page_role_insert 
		AFTER INSERT ON page_role
		FOR EACH ROW 
	BEGIN
		
	IF NEW.role = 'owner' THEN
    
	INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'create',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'delete',NEW.page_id,NEW.developer_id);
	
    ELSEIF NEW.role = 'admin' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'create',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'delete',NEW.page_id,NEW.developer_id);
   
    ELSEIF NEW.role = 'writer' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'create',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
   
    ELSEIF NEW.role = 'editor' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
 
    ELSEIF NEW.role = 'reviewer' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
   
	END IF;

	end$$
DELIMITER ;



DELIMITER $$
USE `cs5200_fall2018_A2_amritanair`$$
CREATE DEFINER=`amritanair`@`%` TRIGGER after_page_role_update 
		AFTER UPDATE ON page_role
		FOR EACH ROW 
	BEGIN
		
	Delete from page_privilege where page_privilege.developer_id = OLD.developer_id and page_privilege.page_id = OLD.page_id;
    
	IF NEW.role = 'owner' THEN
    
	INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'create',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'delete',NEW.page_id,NEW.developer_id);
	
    ELSEIF NEW.role = 'admin' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'create',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'delete',NEW.page_id,NEW.developer_id);
   
    ELSEIF NEW.role = 'writer' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'create',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
   
    ELSEIF NEW.role = 'editor' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'update',NEW.page_id,NEW.developer_id);
 
    ELSEIF NEW.role = 'reviewer' THEN
    INSERT INTO page_privilege (privilege,page_id,developer_id) VALUES ( 'read',NEW.page_id,NEW.developer_id);
   
	END IF;

	end$$
DELIMITER ;

DELIMITER $$
USE `cs5200_fall2018_A2_amritanair`$$
CREATE DEFINER=`amritanair`@`%` TRIGGER after_page_role_delete
		AFTER DELETE ON page_role
		FOR EACH ROW 
        
	BEGIN
    
    Delete from page_privilege where page_privilege.developer_id = OLD.developer_id and page_privilege.page_id = OLD.page_id;
    
	end$$
DELIMITER ;
