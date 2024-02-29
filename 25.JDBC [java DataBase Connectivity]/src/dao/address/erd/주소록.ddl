DROP TABLE address CASCADE CONSTRAINTS;

CREATE TABLE address(
		no                            		NUMBER(10)		 NULL ,
		name                          		VARCHAR2(50)		 NOT NULL,
		phone                         		VARCHAR2(50)		 NOT NULL,
		address                       		VARCHAR2(100)		 DEFAULT '서울시'		 NULL 
);

DROP SEQUENCE address_no_SEQ;

CREATE SEQUENCE address_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



ALTER TABLE address ADD CONSTRAINT IDX_address_PK PRIMARY KEY (no);

