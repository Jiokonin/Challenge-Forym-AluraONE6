ALTER TABLE topic
    ADD COLUMN fk_user BIGINT NULL,
    ADD CONSTRAINT fk_user_topic FOREIGN KEY (fk_user) REFERENCES user(id);

ALTER TABLE user
    ADD COLUMN `name` VARCHAR(100) NOT NULL;