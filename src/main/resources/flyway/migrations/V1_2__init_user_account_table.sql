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