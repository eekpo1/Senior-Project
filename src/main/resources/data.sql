insert into STUDENT (ID, FIRST_NAME, LAST_NAME) values (1, 'Eddie', 'Ekpo');
INSERT INTO ADMIN (ID, FIRST_NAME, LAST_NAME, USERNAME, SCHOOL_ID) VALUES (null, 'Chengwei', 'Lei', 'clei', 123 );
INSERT INTO ADMIN(ID, FIRST_NAME, LAST_NAME, USERNAME, SCHOOL_ID) VALUES (null, 'Melissa', 'Danforth', 'mdanforth', 125);
-- Hibernate: drop table admin if exists
-- Hibernate: drop table authorities if exists
-- Hibernate: drop table course if exists
-- Hibernate: drop table student if exists
-- Hibernate: drop table students_in if exists
-- Hibernate: drop table users if exists
-- Hibernate: drop sequence if exists hibernate_sequence
--     Hibernate: create sequence hibernate_sequence start with 1 increment by 1
--     Hibernate: create table admin (id bigint not null, first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), primary key (id))
--     Hibernate: create table authorities (username varchar(255) not null, authority varchar(255) not null, primary key (username))
--     Hibernate: create table course (id bigint not null, name varchar(255), section varchar(255), last_update date, location varchar(255), updated boolean not null, instructor bigint, primary key (id))
--     Hibernate: create table student (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id))
--     Hibernate: create table students_in (student_id bigint not null, course_id bigint not null, primary key (student_id, course_id))
--     Hibernate: create table users (username varchar(64) not null, enabled boolean not null, password varchar(255), primary key (username))
--     Hibernate: alter table course add constraint FKhat9ro0heltc6e8bqwqfc0vu4 foreign key (instructor) references admin
--     Hibernate: alter table students_in add constraint FKsg965011hvpxytafbq5ufa5r8 foreign key (course_id) references student
--     Hibernate: alter table students_in add constraint FKr8lh42ilyyf9sf1swm1qtrfgd foreign key (student_id) references course


-- CREATE DATABASE SeniorProject;
-- 
-- CREATE TABLE IF NOT EXISTS Admin (
--     adminID int NOT NULL,
--     fName varchar(255) NOT NULL,
--     lName varchar(255) NOT NULL,
--     loginID varchar(255) NOT NULL,
--     adminPassword varchar(255) NOT NULL,
--     roleType int NOT NULL,
--     PRIMARY KEY (adminID)
-- );
-- INSERT INTO Admin (first_name, last_name, login, password) VALUES ("Chengwei", "Lei", "clei", "password1", null );

-- SELECT * FROM Admin;
-- +---------+----------+-------+---------+---------------+----------+
-- | adminID | fName    | lName | loginID | adminPassword | roleType |
-- +---------+----------+-------+---------+---------------+----------+
-- |       1 | Chengwei | Lei   | clei    | password1     |        1 |
-- +---------+----------+-------+---------+---------------+----------+

-- CREATE TABLE IF NOT EXISTS Student (
--     studentID int NOT NULL,
--     fName varchar(255) NOT NULL,
--     lName varchar(255) NOT NULL,
--     loginID varchar(255) NOT NULL,
--     studentPassword varchar(255) NOT NULL,
--     PRIMARY KEY (studentID)
-- );

-- INSERT INTO Student (fName, lName, loginID, studentPassword) VALUES ("Nicholas", "Kalar", "nkalar", "password1");
-- INSERT INTO Student (fName, lName, loginID, studentPassword) VALUES ("Eddie", "Ekpo", "eekpo", "password1");
-- INSERT INTO Student (fName, lName, loginID, studentPassword) VALUES ("Ewdin", "Hernanadez", "ehernanadez", "password1");
--
-- SELECT * FROM Student;
-- +-----------+----------+------------+-------------+-----------------+
-- | studentID | fName    | lName      | loginID     | studentPassword |
-- +-----------+----------+------------+-------------+-----------------+
-- |         1 | Nicholas | Kalar      | nkalar      | password1       |
-- |         2 | Eddie    | Ekpo       | eekpo       | password1       |
-- |         3 | Ewdin    | Hernanadez | ehernanadez | password1       |
-- +-----------+----------+------------+-------------+-----------------+

-- CREATE TABLE IF NOT EXISTS Course (
--     courseID int NOT NULL AUTO_INCREMENT,
--     courseName varchar(255),
--     instructorID varchar(255),
--     updated BOOLEAN,
--     PRIMARY KEY (courseID)
-- );

-- SELECT * FROM Course;
-- +----------+------------------+--------------+---------+
-- | courseID | courseName       | instructorID | updated |
-- +----------+------------------+--------------+---------+
-- |        1 | Senior Project 1 | 1            |       0 |
-- +----------+------------------+--------------+---------+

-- INSERT INTO Course (courseName, instructorID, updated) VALUES ("Senior Project 1", 1, FALSE);

-- CREATE TABLE IF NOT EXISTS Sylabus (
--     courseID int NOT NULL,
--     lastUpdate DATETIME,
--     location varchar(255),
--     PRIMARY KEY (courseID),
--     FOREIGN KEY (courseID) REFERENCES Course(courseID)
-- );
-- 
-- CREATE TABLE IF NOT EXISTS Roster (
--     courseID int NOT NULL,
--     studentID int NOT NU`LL,
--     adminID int NOT NULL,
--     PRIMARY KEY (courseID, studentID, adminID),
--     FOREIGN KEY (courseID) REFERENCES Course(courseID),
--     FOREIGN KEY (studentID) REFERENCES Student(studentID),
--     FOREIGN KEY (adminID) REFERENCES Admin(adminID)
-- );

-- INSERT INTO Roster (courseID, studentID, adminID) VALUES (1, 1, 1);
-- INSERT INTO Roster (courseID, studentID, adminID) VALUES (1, 2, 1);
-- INSERT INTO Roster (courseID, studentID, adminID) VALUES (1, 3, 1);
--
-- SELECT * FROM Roster;
-- +----------+-----------+---------+
-- | courseID | studentID | adminID |
-- +----------+-----------+---------+
-- |        1 |         1 |       1 |
-- |        1 |         2 |       1 |
-- |        1 |         3 |       1 |
-- +----------+-----------+---------+

-- CREATE TABLE IF NOT EXISTS Roles (
--     roleType int,
--     roleLabel varchar(255)
-- );

-- INSERT INTO Roles (roleType, roleLabel) VALUES (0, "Administrator");
-- INSERT INTO Roles (roleType, roleLabel) VALUES (1, "Professor");

-- SELECT * FROM Roles;
-- +----------+---------------+
-- | roleType | roleLabel     |
-- +----------+---------------+
-- |        0 | Administrator |
-- |        1 | Professor     |
-- +----------+---------------+