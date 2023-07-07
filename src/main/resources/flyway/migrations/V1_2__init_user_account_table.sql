CREATE TABLE user_account (
user_account_id SERIAL         NOT NULL,
email           VARCHAR (32)   NOT NULL,
phone           VARCHAR (11)   NOT NULL,
password        VARCHAR (32)   NOT NULL,
user_type       VARCHAR (32)   NOT NULL,
PRIMARY KEY (user_account_id),
UNIQUE (email)
);