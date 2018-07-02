-- ----------------------------------------------------------------------------------------
-- DML Script for ADMS
-- ----------------------------------------------------------------------------------------
-- * AdminDAO *
-- readPwd(pwd)
-- updatePwd(newPwd)
-- read()
-- updateInfo(AdminVO)
-- ----------------------------------------------------------------------------------------
-- readPwd('00000000')
SELECT * FROM admin WHERE pwd LIKE sha1('11111111');

-- updatePwd('11111111')
UPDATE admin SET pwd=sha('11111111') WHERE id LIKE 'admin';

-- read()
SELECT * FROM admin WHERE id like 'admin';

-- updateInfo("도라에몽", "남", "21", "doraemong@doraemong.com", "010-3421-4212", "도라에몽.jpg", "tempPath", "tempPath")
UPDATE admin SET
	name='도라에몽',
    sex='남',
    age=21,
    email='doraemong@doraemong.com',
    phoneNum='010-3421-4212',
    originalFileName='도라에몽.jpg',
    storedFolderName='tempPath',
    storedFileName='tempPath'
WHERE id LIKE 'admin';

-- ----------------------------------------------------------------------------------------
-- * UserDAO *
-- create(UserVO)
-- read(uno)
-- update(UserVO)
-- delete(uno)
-- list(Criteria)
-- readForAccess(accessKey)
-- updateFaceEnc(encoding)
-- ----------------------------------------------------------------------------------------
-- create('똘똘이', '여', 30, 'ddolddol@naver.com', '010-2222-2212', '똘똘.jpg', '201807021344', 'ksiekwao.jpg')
INSERT INTO user(name, sex, age, email, phoneNum, originalFileName, storedFolderName, storedFileName)
VALUES ('통통이', '남', 10, 'tongtong@naver.com', '010-2222-2212', '똘똘.jpg', '201807021344', 'ksiekwao.jpg');

-- read(1)
SELECT * FROM user WHERE uno=1;

-- update('똘똘맘', '여', 76, 'ddolmom@naver.com', '010-2212-2222', '똘맘.jpg', '201807021349', 'sakasghae.jpg')
UPDATE user SET
	name='똘똘맘',
    sex='여',
    age=76,
    email='ddolmom@naver.com',
    phoneNum='010-2212-2222',
    originalFileName='똘맘.jpg',
    storedFolderName='201807021349',
    storedFileName='sakasghae.jpg'
WHERE uno=2;

-- delete(2)
DELETE FROM user WHERE uno=2;

-- list(1, 10, 'n', '똘똘맘')
SELECT * FROM user
WHERE uno>0
AND name LIKE CONCAT('%', '콩', '%')
-- AND age=?
-- AND phoneNum LIKE CONCAT('%', '010-2253', '%')
-- AND email LIKE CONCAT('%', '@naver.com', '%')
ORDER BY uno desc
LIMIT 0, 10;

-- readForAccess(accessKey)
SELECT uno, accessKey, storedFolderName, storedFileName, pictureEncoding FROM user
WHERE accessKey like 'b1e047bd3dd9e259b16aa95dd5822b7ade8e9e02';

-- updateFaceEnc(encoding)
UPDATE user SET
	pictureEncoding='12315832958129481985'
WHERE uno=1;

-- ----------------------------------------------------------------------------------------
-- * UserDAO *
-- create(LogVO)
-- read(lno)
-- list(Criteria)
-- monthlyHistForUser(uno)
-- monthlyHistForDoorlock(mac)
-- rcntHistOnUser(uno)
-- rcntHistOnDoorlock(mac)
-- ----------------------------------------------------------------------------------------
-- create(LogVO)
INSERT INTO log(name, location, accessTime, isSuccess, storedFolderName, storedFileName, distance, uno, mac)
VALUES ('통통이', '자료보관실1', now(), 1, '20180702141322', 'kaieweirqowes.jpg', 0.2142, 4, 'F8-63-3F-40-7B-5D');

-- read(lno)
SELECT name, location, accessTime, isSuccess, storedFolderName, storedFileName, distance FROM log WHERE lno=1;

-- list(Criteria)
SELECT lno, name, location, accessTime, isSuccess, storedFolderName, storedFileName, distance
FROM log
WHERE (accessTime BETWEEN '2018-07-02 14:00:00' AND '2018-07-02 14:20:00')
AND (name LIKE CONCAT('%','콩콩이','%'))
AND (location LIKE CONCAT('%','자료','%'))
ORDER BY accessTime, name, location DESC
LIMIT 0, 10;

-- monthlyHistForUser(uno)
SELECT location, COUNT(*) AS cnt
FROM log
WHERE uno=3 AND accessTime > now() - INTERVAL 1 MONTH
GROUP BY location
ORDER BY cnt DESC
LIMIT 0, 5;

-- monthlyHistForDoorlock(mac)
SELECT name, COUNT(*) AS cnt
FROM log
WHERE mac like 'F8-63-3F-40-7B-5D' AND accessTime > now() - INTERVAL 1 MONTH
GROUP BY name
ORDER BY cnt DESC
LIMIT 0, 5;

-- rcntHistOnUser(uno)
SELECT lno, name, location, accessTime, isSuccess, storedFolderName, storedFileName, distance
FROM log
WHERE uno=2
ORDER BY accessTime DESC
LIMIT 0, 10;

-- rcntHistOnDoorlock(mac)
SELECT lno, name, location, accessTime, isSuccess, storedFolderName, storedFileName, distance
FROM log
WHERE mac like 'F8-63-3F-40-7B-5D'
ORDER BY accessTime DESC
LIMIT 0, 10;

-- ----------------------------------------------------------------------------------------
-- * UserDAO *
-- create(DoorlockVO)
-- read(mac)
-- update(DoorlockVO)
-- delete(mac)
-- list(Criteria)
-- updateConnectionState(mac, isConn)
-- updateLastConTime(mac)
-- ----------------------------------------------------------------------------------------
-- create(DoorlockVO)
INSERT INTO doorlock(mac, location)
VALUES ('C8-23-3A-40-7B-6D', '자료보관실2');

-- read(mac)
SELECT * FROM doorlock WHERE mac LIKE 'C8-23-3A-40-7B-6D';

-- update(DoorlockVO)
UPDATE doorlock SET location='해외자료실1'
WHERE mac like 'C8-23-3A-40-7B-6D';

-- delete(mac)
DELETE FROM doorlock WHERE mac LIKE 'C8-23-3A-40-7B-6D';

-- list(Criteria)
SELECT * FROM doorlock
WHERE location LIKE CONCAT('%', '자', '%')
ORDER BY isConnected desc, lastConTime desc, location desc
LIMIT 0, 10;

-- updateConnectionState(mac, isConn)
UPDATE doorlock SET isConnected=0
WHERE mac LIKE 'C8-23-3A-40-7B-6D';

-- updateLastConTime(mac)
UPDATE doorlock SET lastConTime = now()
WHERE mac LIKE 'C8-23-3A-40-7B-6D';