/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/10/14 16:12:42                          */
/*==============================================================*/


DROP TABLE IF EXISTS BLOG;

DROP TABLE IF EXISTS BLOGTAG;

DROP TABLE IF EXISTS COMMENT;

DROP TABLE IF EXISTS TAG;

DROP TABLE IF EXISTS TYPE;

DROP TABLE IF EXISTS USER;

/*==============================================================*/
/* Table: BLOG                                                  */
/*==============================================================*/
CREATE TABLE BLOG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   CONTENT              VARCHAR(255),
   FIRSTPICTURE         TEXT,
   FLAG                 VARCHAR(255),
   VIEWS                INT,
   APPRECIATION         BIT,
   COPYRIGHT            BIT,
   COMMENTED            BIT,
   PUBLISHED            BIT,
   CREATETIME           DATE,
   UPDATETIME           DATE,
   USERID               BIGINT,
   TYPEID               BIGINT,
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: BLOGTAG                                               */
/*==============================================================*/
CREATE TABLE BLOGTAG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   TAGID                BIGINT,
   BLOGID               BIGINT,
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: COMMENT                                               */
/*==============================================================*/
CREATE TABLE COMMENT
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   PARENTID             BIGINT,
   NICKNAME             VARCHAR(255),
   EMAIL                VARCHAR(255),
   AVATAR               VARCHAR(255),
   CONTENT              VARCHAR(255),
   CREATETIME           DATE,
   BLOGID               BIGINT,
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: TAG                                                   */
/*==============================================================*/
CREATE TABLE TAG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   TAGNAME              VARCHAR(255),
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: TYPE                                                  */
/*==============================================================*/
CREATE TABLE TYPE
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   TYPENAME             VARCHAR(255),
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
CREATE TABLE USER
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   NICKNAME             VARCHAR(255),
   USERNAME             VARCHAR(255),
   PASSWORD             VARCHAR(255),
   EMAIL                VARCHAR(255),
   TYPE                 INT,
   AVATAR               TEXT,
   CREATETIME           DATE,
   UPDATETIME           DATE,
   PRIMARY KEY (ID)
);

ALTER TABLE BLOG ADD CONSTRAINT FK_REFERENCE_1 FOREIGN KEY (USERID)
      REFERENCES USER (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BLOG ADD CONSTRAINT FK_BLOG_TYPE FOREIGN KEY (TYPEID)
      REFERENCES TYPE (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BLOGTAG ADD CONSTRAINT FK_REFERENCE_4 FOREIGN KEY (BLOGID)
      REFERENCES BLOG (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE BLOGTAG ADD CONSTRAINT FK_REFERENCE_5 FOREIGN KEY (TAGID)
      REFERENCES TAG (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE COMMENT ADD CONSTRAINT FK_REFERENCE_2 FOREIGN KEY (BLOGID)
      REFERENCES BLOG (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

