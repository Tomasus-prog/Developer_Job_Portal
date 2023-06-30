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