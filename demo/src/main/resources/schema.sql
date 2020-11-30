create database if not exists white_jotter;

use white_jotter;

DROP TABLE IF EXISTS vip;
CREATE TABLE vip (
  id int(11) NOT NULL AUTO_INCREMENT,
  username char(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS food;
CREATE TABLE food (
    id int(11) NOT NULL AUTO_INCREMENT,
    picture varchar(255) DEFAULT '',
    name varchar(255) NOT NULL DEFAULT '',
    cook varchar(255) DEFAULT NULL,
    abs varchar(255) DEFAULT NULL,
    cid int(11) DEFAULT NULL,
    PRIMARY KEY (id),
    KEY fk_food_kind_on_cid (cid),
    CONSTRAINT fk_food_kind_on_cid FOREIGN KEY (cid) REFERENCES kind (id) ON DELETE SET NULL ON UPDATE CASCADE
);

DROP TABLE IF EXISTS kind;
    CREATE TABLE kind (
    id int(11) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);