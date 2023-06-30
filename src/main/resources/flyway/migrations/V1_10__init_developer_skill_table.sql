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