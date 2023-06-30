CREATE TABLE user_type (
user_type_id    SERIAL          NOT NULL,
user_type_name  VARCHAR (32)    NOT NULL,
PRIMARY KEY (user_type_id)
);

CREATE TABLE user_account (
user_account_id SERIAL         NOT NULL,
email           VARCHAR (32)   NOT NULL,
phone           VARCHAR (11)   NOT NULL,
password        VARCHAR (32)   NOT NULL,
user_type_id    INT            NOT NULL,
PRIMARY KEY (user_account_id),
UNIQUE (email),
CONSTRAINT fk_user_account_user_type
FOREIGN KEY (user_type_id)
REFERENCES user_type (user_type_id)
);

CREATE TABLE image_profile (
image_profile_id SERIAL         NOT NULL,
image_name      VARCHAR (32)    NOT NULL,
image           bytea           NOT NULL,
PRIMARY KEY (image_profile_id)
);

CREATE TABLE developer_profile (
developer_profile_id SERIAL      NOT NULL,
name                 VARCHAR(32) NOT NULL,
surname              VARCHAR(32) NOT NULL,
gender               VARCHAR(32),
date_of_birth        DATE        NOT NULL,
user_image           BYTEA,
profile_status       BOOLEAN     NOT NULL,
user_account_id      INT         NOT NULL,
PRIMARY KEY (developer_profile_id),
CONSTRAINT fk_developer_profile_user_account
FOREIGN KEY (user_account_id)
REFERENCES user_account (user_account_id)
);

CREATE TABLE company (
company_id      SERIAL      NOT NULL,
company_name    VARCHAR(32) NOT NULL,
size            INT         NOT NULL,
website         VARCHAR(64) NOT NULL,
industry        VARCHAR(32) NOT NULL,
description     VARCHAR(100) NOT NULL,
user_account_id INT         NOT NULL,
PRIMARY KEY (company_id),
CONSTRAINT fk_company_user_account
FOREIGN KEY (user_account_id)
REFERENCES user_account (user_account_id)
);

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

 CREATE TABLE job_type (
 job_type_id   SERIAL NOT NULL,
 job_type      VARCHAR (32) NOT NULL,
 PRIMARY KEY (job_type_id)
 );

CREATE TABLE job_ad (
job_ad_id       SERIAL      NOT NULL,
title           VARCHAR(32) NOT NULL,
date_posted     DATE        NOT NULL,
location        VARCHAR(32) ,
work_remote     VARCHAR(32) NOT NULL,
salary          NUMERIC(7,2) ,
company_id      INT         NOT NULL,
job_type_id     INT         NOT NULL,
PRIMARY KEY (job_ad_id),
CONSTRAINT  fk1_job_ad_company_id
FOREIGN KEY (company_id)
REFERENCES company (company_id),
CONSTRAINT fk2_job_ad_job_type
FOREIGN KEY (job_type_id)
REFERENCES job_type (job_type_id)
);

CREATE TABLE skill_set (
skill_set_id    SERIAL NOT NULL,
skill_name      VARCHAR(32) NOT NULL,
PRIMARY KEY (skill_set_id)
);

CREATE TABLE job_ad_skill (
job_ad_skill_id     SERIAL NOT NULL,
skill_level         INT    NOT NULL,
job_ad_id           INT    NOT NULL,
skill_set_id        INT    NOT NULL,
PRIMARY KEY (job_ad_skill_id),
CONSTRAINT  fk1_job_ad_skill_job_ad
FOREIGN KEY (job_ad_id)
REFERENCES job_ad (job_ad_id),
CONSTRAINT fk2_job_ad_skill_skill_set
FOREIGN KEY (skill_set_id)
REFERENCES skill_set (skill_set_id)
);

CREATE TABLE developer_skill (
developer_skill_id      SERIAL NOT NULL,
skill_level             INT     NOT NULL,
developer_profile_id    INT     NOT NULL,
skill_set_id            INT     NOT NULL,
PRIMARY KEY (developer_skill_id),
CONSTRAINT fk1_developer_skill_developer_profile
FOREIGN KEY (developer_profile_id)
REFERENCES developer_profile (developer_profile_id),
CONSTRAINT fk2_developer_skill_skill_set_id
FOREIGN KEY (skill_set_id)
REFERENCES skill_set (skill_set_id)
);



CREATE TABLE experience_details (
experience_id           SERIAL      NOT NULL,
job_position            VARCHAR(32) NOT NULL,
start_date              DATE        NOT NULL,
end_date                DATE                ,
employer_name           VARCHAR(32) NOT NULL,
description             VARCHAR(200)NOT NULL,
developer_profile_id    INT         NOT NULL,
PRIMARY KEY (experience_id),
CONSTRAINT fk_experience_details_developer_profile
FOREIGN KEY (developer_profile_id)
REFERENCES developer_profile (developer_profile_id)
);

CREATE TABLE education_details (
education_id        SERIAL NOT NULL,
school_name         VARCHAR(32) NOT NULL,
study_direction     VARCHAR(32) NOT NULL,
level_education     VARCHAR(32) NOT NULL,
completion_date     DATE,
developer_profile_id INT NOT NULL,
PRIMARY KEY (education_id),
CONSTRAINT fk_education_details_developer_profile
FOREIGN KEY (developer_profile_id)
REFERENCES developer_profile (developer_profile_id)
);