CREATE TABLE developer_profile_activity (
developer_profile_activity_id  SERIAL NOT NULL,
status_employment              BOOLEAN NOT NULL,
date_employment                DATE           ,
company_id                     INT    NOT NULL,
developer_profile_id           INT    NOT NULL,
PRIMARY KEY (developer_profile_activity_id),
CONSTRAINT fk1_developer_profile_activity_company
FOREIGN KEY (company_id)
REFERENCES company (company_id),
CONSTRAINT fk2_developer_profile_activity_developer_profile
FOREIGN KEY (developer_profile_id)
REFERENCES developer_profile (developer_profile_id)
 );