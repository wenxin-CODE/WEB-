create database if not exists white_jotter;

use white_jotter;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username char(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS book;
CREATE TABLE book (
    id int(11) NOT NULL AUTO_INCREMENT,
    cover varchar(255) DEFAULT '',
    title varchar(255) NOT NULL DEFAULT '',
    author varchar(255) DEFAULT '',
    date varchar(20) DEFAULT '',
    press varchar(255) DEFAULT '',
    abs varchar(255) DEFAULT NULL,
    cid int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    KEY fk_book_category_on_cid (cid),
    CONSTRAINT fk_book_category_on_cid FOREIGN KEY (cid) REFERENCES category (id) ON DELETE SET NULL ON UPDATE CASCADE
);

DROP TABLE IF EXISTS category;
    CREATE TABLE category (
    id int(11) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);