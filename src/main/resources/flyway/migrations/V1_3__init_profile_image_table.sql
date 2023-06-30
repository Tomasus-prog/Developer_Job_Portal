CREATE TABLE image_profile (
image_profile_id SERIAL         NOT NULL,
image_name      VARCHAR (32)    NOT NULL,
image           bytea           NOT NULL,
PRIMARY KEY (image_profile_id)
);