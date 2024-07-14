--liquibase formatted sql
--changeset bladly:02_create_books logicalFilePath:02_create_books.sql

CREATE TABLE IF NOT EXISTS BOOKS (
    book_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY (book_id)
);

GRANT ALL PRIVILEGES ON TESTDB.BOOKS TO SYSADM;
FLUSH PRIVILEGES;
