CREATE TABLE developer_profile (
developer_profile_id SERIAL      NOT NULL,
name                 VARCHAR(32) NOT NULL,
surname              VARCHAR(32) NOT NULL,
gender               VARCHAR(32),
date_of_birth        DATE        NOT NULL,
profile_status       BOOLEAN        NOT NULL,
image_profile_id      INT        NOT NULL,
user_account_id      INT         NOT NULL,
PRIMARY KEY (developer_profile_id),
CONSTRAINT fk_developer_profile_user_account
FOREIGN KEY (user_account_id)
REFERENCES user_account (user_account_id),
CONSTRAINT fk_developer_profile_image_profile
FOREIGN KEY (image_profile_id)
REFERENCES image_profile (image_profile_id)
);