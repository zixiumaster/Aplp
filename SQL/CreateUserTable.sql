-- 建库
-- CREATE DATABASE aplp;

use aplp;

-- 建表，学生
CREATE TABLE user_student
(
    id          VARCHAR(50) NULL UNIQUE,
    name        VARCHAR(50) NULL,
    phone       VARCHAR(50) NULL UNIQUE,
    email       VARCHAR(50) NULL UNIQUE,
    password    VARCHAR(50) NOT NULL,

    department  VARCHAR(50) NULL,
    classe       VARCHAR(50) NULL
);

-- 建表，教师
CREATE TABLE user_teacher
(
    id         VARCHAR(50) NULL UNIQUE,
    name       VARCHAR(50) NULL,
    phone      VARCHAR(50) NULL UNIQUE,
    email      VARCHAR(50) NULL UNIQUE,
    password   VARCHAR(50) NOT NULL,

    department VARCHAR(50) NULL
);

-- 建表，管理员
CREATE TABLE user_administrator
(
    id       VARCHAR(50) NULL UNIQUE,
    name     VARCHAR(50) NULL,
    phone    VARCHAR(50) NULL UNIQUE,
    email    VARCHAR(50) NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

