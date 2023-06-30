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