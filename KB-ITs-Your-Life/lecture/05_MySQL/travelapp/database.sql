DROP TABLE IF EXISTS tbl_travel2;
CREATE TABLE tbl_travel2
(
    no INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    district VARCHAR(50) NOT NULL,
    title VARCHAR(512) NOT NULL,
    description TEXT,
    address VARCHAR(512),
    phone VARCHAR(256)
);