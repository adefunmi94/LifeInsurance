
CREATE DATABASE IF NOT EXISTS `lifeinsurance_database`;
USE `lifeinsurance_database`;

GRANT ALL PRIVILEGES ON lifeinsurance_database.* To 'oldmutual'@ '%';

DROP TABLE IF EXISTS `lifeinsurance`;

CREATE TABLE lifeinsurance (
    id int NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(128) NOT NULL,
    phone int (128) NOT NULL,
    gender VARCHAR(128) NOT NULL,
    yearOfBirth int (20) NOT NULL,
    monthOfBirth int (20) NOT NULL,
   dayOfBirth int (20) NOT NULL,
   amount_assured int (20) NOT NULL,
   term_cover int (20) NOT NULL,
   
   paymentFrequency  VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)  
    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= latin1;

INSERT INTO `lifeinsurance` VALUES
 (2,'Ifeoluwa',07039,'female',1990,11,24,10,'monthly');