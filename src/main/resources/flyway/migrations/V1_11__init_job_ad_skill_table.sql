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