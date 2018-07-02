-- Access Data Management System DB 생성
CREATE DATABASE IF NOT EXISTS admsdb;
USE admsdb;

-- 관리자 테이블
CREATE TABLE IF NOT EXISTS admin (
	id VARCHAR(20) NOT NULL,
    pwd VARCHAR(40) NOT NULL,
    name VARCHAR(50) NOT NULL,
    sex VARCHAR(2) NOT NULL,
    age INT(3) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phoneNum VARCHAR(15) NOT NULL,
    originalFileName VARCHAR(260),
    storedFolderName VARCHAR(260),
    storedFileName VARCHAR(36),
    PRIMARY KEY(id)
);

INSERT INTO admin(id, pwd, name, sex, age, email, phoneNum)
VALUES ('admin', sha1('00000000'), '노형래', '남', 24, 'hrnoh24@gmail.com', '010-8281-9331');

-- 출입자 테이블
CREATE TABLE IF NOT EXISTS user (
	uno INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    sex VARCHAR(2) NOT NULL,
    age INT(3) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phoneNum VARCHAR(15) NOT NULL,
    originalFileName VARCHAR(260) NOT NULL,
    storedFolderName VARCHAR(260) NOT NULL,
    storedFileName VARCHAR(36) NOT NULL,
    pictureEncoding TEXT,
    accessKey VARCHAR(40),
    PRIMARY KEY(uno)
);

-- IoT 도어락 테이블
CREATE TABLE IF NOT EXISTS doorlock (
	mac VARCHAR(20) NOT NULL,
    location VARCHAR(50) NOT NULL,
    lastConTime TIMESTAMP,
    isConnected BIT NOT NULL DEFAULT 0,
    PRIMARY KEY(mac)
);

-- 출입 기록 테이블
CREATE TABLE IF NOT EXISTS log (
	lno INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL,
    accessTime TIMESTAMP NOT NULL DEFAULT now(),
    isSuccess BIT NOT NULL,
    storedFolderName VARCHAR(260) NOT NULL,
    storedFileName VARCHAR(36) NOT NULL,
    distance DOUBLE DEFAULT NULL,
    uno INT NOT NULL,
    mac VARCHAR(20) NOT NULL,
    PRIMARY KEY(lno),
    FOREIGN KEY(uno) REFERENCES user(uno) ON DELETE CASCADE,
    FOREIGN KEY(mac) REFERENCES doorlock(mac) ON DELETE CASCADE
);

-- 접근 키 발행 트리거
DELIMITER $$
CREATE TRIGGER issues_access_key
BEFORE INSERT ON user
FOR EACH ROW
SET
	NEW.accessKey = sha1(concat(NEW.uno+1, NEW.age, NEW.name));
$$
DELIMITER ;

-- 접근 키 갱신 트리거
DELIMITER $$
CREATE TRIGGER update_access_key
BEFORE UPDATE ON user
FOR EACH ROW
SET
	NEW.accessKey = sha1(concat(NEW.uno, NEW.age, NEW.name));
$$
DELIMITER ;

-- 출입자 데이터
INSERT INTO user(name, sex, age, email, phoneNum, originalFileName, storedFolderName, storedFileName)
VALUES ('콩콩이', '여', 21, 'kongkong@naver.com', '010-5050-0000', 'tempPath', 'tempPath', 'tempPath');

-- IOT 도어락 데이터
INSERT INTO doorlock(mac, location)
VALUES ('F8-63-3F-40-7B-5D', '자료보관실1');

-- 출입 기록 데이터
INSERT INTO log(name, location, isSuccess, storedFolderName, storedFileName, uno, mac)
VALUES ('콩콩이', '자료보관실1', 1, 'tempPath', 'tempPath', 1, 'F8-63-3F-40-7B-5D');