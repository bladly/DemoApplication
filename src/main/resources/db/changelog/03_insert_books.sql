--liquibase formatted sql
--changeset bladly:03_insert_books logicalFilePath:03_insert_books.sql

INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 1');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 2');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 3');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 4');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 5');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 6');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 7');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 8');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 9');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 10');
INSERT INTO TESTDB.BOOKS (title) VALUES ('Title 11');

COMMIT;
