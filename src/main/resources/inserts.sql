CREATE DATABASE SeniorProject;

CREATE TABLE IF NOT EXISTS Admin (
    adminID int NOT NULL AUTO_INCREMENT,
    fName varchar(255),
    lName varchar(255),
    loginID varchar(255),
    adminPassword varchar(255),
    roleType int,
    PRIMARY KEY (adminID)
);

INSERT INTO Admin (fName, lName, loginID, adminPassword, roleType) VALUES ("Chengwei", "Lei", "clei", "password1", 1);

SELECT * FROM Admin;
-- +---------+----------+-------+---------+---------------+----------+
-- | adminID | fName    | lName | loginID | adminPassword | roleType |
-- +---------+----------+-------+---------+---------------+----------+
-- |       1 | Chengwei | Lei   | clei    | password1     |        1 |
-- +---------+----------+-------+---------+---------------+----------+

CREATE TABLE IF NOT EXISTS Student (
    studentID int NOT NULL AUTO_INCREMENT,
    fName varchar(255),
    lName varchar(255),
    loginID varchar(255),
    studentPassword varchar(255),
    PRIMARY KEY (studentID)
);

INSERT INTO Student (fName, lName, loginID, studentPassword) VALUES ("Nicholas", "Kalar", "nkalar", "password1");
INSERT INTO Student (fName, lName, loginID, studentPassword) VALUES ("Eddie", "Ekpo", "eekpo", "password1");
INSERT INTO Student (fName, lName, loginID, studentPassword) VALUES ("Ewdin", "Hernanadez", "ehernanadez", "password1");

SELECT * FROM Student;
-- +-----------+----------+------------+-------------+-----------------+
-- | studentID | fName    | lName      | loginID     | studentPassword |
-- +-----------+----------+------------+-------------+-----------------+
-- |         1 | Nicholas | Kalar      | nkalar      | password1       |
-- |         2 | Eddie    | Ekpo       | eekpo       | password1       |
-- |         3 | Ewdin    | Hernanadez | ehernanadez | password1       |
-- +-----------+----------+------------+-------------+-----------------+

CREATE TABLE IF NOT EXISTS Course (
    courseID int NOT NULL AUTO_INCREMENT,
    courseName varchar(255),
    instructorID varchar(255),
    updated BOOLEAN,
    PRIMARY KEY (courseID)
);

SELECT * FROM Course;
-- +----------+------------------+--------------+---------+
-- | courseID | courseName       | instructorID | updated |
-- +----------+------------------+--------------+---------+
-- |        1 | Senior Project 1 | 1            |       0 |
-- +----------+------------------+--------------+---------+

INSERT INTO Course (courseName, instructorID, updated) VALUES ("Senior Project 1", 1, FALSE);

CREATE TABLE IF NOT EXISTS Sylabus (
    courseID int NOT NULL,
    lastUpdate DATETIME,
    location varchar(255),
    PRIMARY KEY (courseID),
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

CREATE TABLE IF NOT EXISTS Roster (
    courseID int NOT NULL,
    studentID int NOT NULL,
    adminID int NOT NULL,
    PRIMARY KEY (courseID, studentID, adminID),
    FOREIGN KEY (courseID) REFERENCES Course(courseID),
    FOREIGN KEY (studentID) REFERENCES Student(studentID),
    FOREIGN KEY (adminID) REFERENCES Admin(adminID)
);

INSERT INTO Roster (courseID, studentID, adminID) VALUES (1, 1, 1);
INSERT INTO Roster (courseID, studentID, adminID) VALUES (1, 2, 1);
INSERT INTO Roster (courseID, studentID, adminID) VALUES (1, 3, 1);

SELECT * FROM Roster;
-- +----------+-----------+---------+
-- | courseID | studentID | adminID |
-- +----------+-----------+---------+
-- |        1 |         1 |       1 |
-- |        1 |         2 |       1 |
-- |        1 |         3 |       1 |
-- +----------+-----------+---------+

CREATE TABLE IF NOT EXISTS Roles (
    roleType int,
    roleLabel varchar(255)
);

INSERT INTO Roles (roleType, roleLabel) VALUES (0, "Administrator");
INSERT INTO Roles (roleType, roleLabel) VALUES (1, "Professor");

SELECT * FROM Roles;
-- +----------+---------------+
-- | roleType | roleLabel     |
-- +----------+---------------+
-- |        0 | Administrator |
-- |        1 | Professor     |
-- +----------+---------------+