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