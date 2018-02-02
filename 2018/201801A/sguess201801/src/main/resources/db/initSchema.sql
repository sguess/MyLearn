# CREATE DATABASE  IF NOT EXISTS `tmp`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE tmp.user
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(15)
);
CREATE UNIQUE INDEX user_id_uindex ON tmp.user (id);
CREATE TABLE tmp.address
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  userId INT,
  name VARCHAR(15) DEFAULT "AddrName",
  addr VARCHAR(255) DEFAULT "AddrDetails"
);
CREATE UNIQUE INDEX address_id_uindex ON tmp.address (id);