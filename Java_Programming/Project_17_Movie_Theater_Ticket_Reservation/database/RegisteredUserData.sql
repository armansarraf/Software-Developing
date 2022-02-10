DROP DATABASE IF EXISTS MOVIETHEATERUSER;
CREATE DATABASE MOVIETHEATERUSER; 
USE MOVIETHEATERUSER;

DROP TABLE IF EXISTS REGISTERED;
CREATE TABLE REGISTERED (
  Username				varchar(15) NOT NULL,
  Password				varchar(15) NOT NULL,
  Fee_renew_date		date,
  Name					varchar(50),
  Address		        varchar(50),
  Bank					varchar(15),
  Email					varchar(50),
  Card_no			    varchar(16),
  Card_cvv				int(3),
  Card_exp				int(4),
  PRIMARY key (Username)
);

INSERT INTO REGISTERED VALUES
('JJ', 'password','2021-05-21','JJ','123, 3 Ave, U of C, SW','Scotiabank','jj@fake.com','4929844610628530',138,0524),
('Sam', 'password','2020-10-21','Sam','456, 7 Ave, U of C, NW','Scotiabank','sam@fake.com','2720999154954117',290,0323),
('Arman','password','2021-10-31','Araman','789, 8 Ave, U of C, NE','TD CANADA TRUST','arman@fake.com','4532316556491131',488,0921),
('Sasan','password','2021-10-31','Sasan','234, 9 Ave, U of C, SE','TD CANADA TRUST','sasan@fake.com','4532316556491131',488,0921);

DROP TABLE IF EXISTS VOUCHER;
CREATE TABLE VOUCHER (
  VoucherID				int(5) NOT NULL,
  Credit				double(5,2),
  Expr_Date				date,
  PRIMARY key (VoucherID)
);

INSERT INTO VOUCHER VALUES 
(20000,14.95,'2021-11-28'),
(20001,12.71,'2021-01-20'),
(20002,17.95,'2021-05-12'),
(20003,15.26,'2021-06-26'),
(20004,14.95,'2020-12-30');

DROP TABLE IF EXISTS BANK;
CREATE TABLE BANK (
  Name         			varchar(15) NOT NULL,
  PRIMARY key (Name)
);

INSERT INTO BANK VALUES
('SCOTIABANK'),
('TD CANADA TRUST'),
('CIBC'),
('RBC'),
('BMO');
    
DROP TABLE IF EXISTS CREDITCARD;
CREATE TABLE CREDITCARD (
  BankName			    varchar(15) NOT NULL, 
  Card_no			    varchar(16),
  Card_cvv				int(3),
  Card_exp				int(4),
  PRIMARY key (Card_no),
  FOREIGN key (BankName) REFERENCES BANK(Name)
  		ON DELETE CASCADE
        ON UPDATE CASCADE
);
    
INSERT INTO CREDITCARD VALUES
	('SCOTIABANK','4929844610628530',138,0524),
    ('SCOTIABANK','2720999154954117',290,0323),
    ('TD CANADA TRUST','4532316556491131',488,0921),
    ('CIBC','5343911733879095',881,0122),
    ('RBC','5409797916016568',723,0722),
    ('BMO','6011014819581872',631,0922);



