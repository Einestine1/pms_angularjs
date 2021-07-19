CREATE TABLE FILE (ID BIGINT NOT NULL, REGISTRATIONDATE DATE, REGISTRATIONNUMBER VARCHAR(255), PLOT_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE FILESTATUS (ID BIGINT NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE MEMBER (ID BIGINT NOT NULL, FNAME VARCHAR(255), LNAME VARCHAR(255), MNAME VARCHAR(255), MEMBERSHIPNUMBER VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE Menu (ID BIGINT NOT NULL, ATTRIBUTE1 VARCHAR(255), ISVISIBLE TINYINT(1) default 0, TITLE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE MENUITEM (HREF VARCHAR(255), Menu_id BIGINT NOT NULL, ISENABLED TINYINT(1) default 0, TARGETFRAME VARCHAR(255), TITLE VARCHAR(255), PRIMARY KEY (Menu_id))
CREATE TABLE PAYMENTSCHEDULE (ID BIGINT NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PLOT (ID BIGINT NOT NULL, PLOTNUMBER VARCHAR(255), PLOTCATEGORY_ID BIGINT, PLOTSIZE_ID BIGINT, PLOTSTATUS_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE PLOTCATEGORY (ID BIGINT NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PLOTSIZE (ID BIGINT NOT NULL, AREA VARCHAR(255), LENGTH VARCHAR(255), WIDTH VARCHAR(255), FILE_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE PLOTSTATUS (ID BIGINT NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE USER (ID BIGINT AUTO_INCREMENT NOT NULL, EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), ISADMIN TINYINT(1) default 0, LASTNAME VARCHAR(255), PASSWORD VARCHAR(255), USERNAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE FILE_FILESTATUS (File_ID BIGINT NOT NULL, fileStatus_ID BIGINT NOT NULL, PRIMARY KEY (File_ID, fileStatus_ID))
CREATE TABLE MEMBER_FILE (file_ID BIGINT NOT NULL, member_ID BIGINT NOT NULL, PRIMARY KEY (file_ID, member_ID))
CREATE TABLE FILE_PLOTCATEGORY (File_ID BIGINT NOT NULL, requestedPlotCategory_ID BIGINT NOT NULL, PRIMARY KEY (File_ID, requestedPlotCategory_ID))
ALTER TABLE FILE ADD CONSTRAINT FK_FILE_PLOT_ID FOREIGN KEY (PLOT_ID) REFERENCES PLOT (ID)
ALTER TABLE MENUITEM ADD CONSTRAINT FK_MENUITEM_Menu_id FOREIGN KEY (Menu_id) REFERENCES Menu (ID)
ALTER TABLE PLOT ADD CONSTRAINT FK_PLOT_PLOTSIZE_ID FOREIGN KEY (PLOTSIZE_ID) REFERENCES PLOTSIZE (ID)
ALTER TABLE PLOT ADD CONSTRAINT FK_PLOT_PLOTSTATUS_ID FOREIGN KEY (PLOTSTATUS_ID) REFERENCES PLOTSTATUS (ID)
ALTER TABLE PLOT ADD CONSTRAINT FK_PLOT_PLOTCATEGORY_ID FOREIGN KEY (PLOTCATEGORY_ID) REFERENCES PLOTCATEGORY (ID)
ALTER TABLE PLOTSIZE ADD CONSTRAINT FK_PLOTSIZE_FILE_ID FOREIGN KEY (FILE_ID) REFERENCES FILE (ID)
ALTER TABLE FILE_FILESTATUS ADD CONSTRAINT FK_FILE_FILESTATUS_fileStatus_ID FOREIGN KEY (fileStatus_ID) REFERENCES FILESTATUS (ID)
ALTER TABLE FILE_FILESTATUS ADD CONSTRAINT FK_FILE_FILESTATUS_File_ID FOREIGN KEY (File_ID) REFERENCES FILE (ID)
ALTER TABLE MEMBER_FILE ADD CONSTRAINT FK_MEMBER_FILE_file_ID FOREIGN KEY (file_ID) REFERENCES FILE (ID)
ALTER TABLE MEMBER_FILE ADD CONSTRAINT FK_MEMBER_FILE_member_ID FOREIGN KEY (member_ID) REFERENCES MEMBER (ID)
ALTER TABLE FILE_PLOTCATEGORY ADD CONSTRAINT FK_FILE_PLOTCATEGORY_requestedPlotCategory_ID FOREIGN KEY (requestedPlotCategory_ID) REFERENCES PLOTCATEGORY (ID)
ALTER TABLE FILE_PLOTCATEGORY ADD CONSTRAINT FK_FILE_PLOTCATEGORY_File_ID FOREIGN KEY (File_ID) REFERENCES FILE (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN_TABLE', 0)
