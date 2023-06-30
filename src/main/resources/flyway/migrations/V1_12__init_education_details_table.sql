CREATE TABLE education_details (
education_id        SERIAL NOT NULL,
school_name         VARCHAR(32) NOT NULL,
study_direction     VARCHAR(32) NOT NULL,
level_education     VARCHAR(32) NOT NULL,
completion_date     DATE    ,
developer_profile_id INT NOT NULL,
PRIMARY KEY (education_id),
CONSTRAINT fk_education_details_developer_profile
FOREIGN KEY (developer_profile_id)
REFERENCES developer_profile (developer_profile_id)
);