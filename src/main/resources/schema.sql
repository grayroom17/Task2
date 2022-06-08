DROP TABLE IF EXISTS students;

CREATE TABLE students (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               firstname VARCHAR(250) NOT NULL,
                               lastname VARCHAR(250) NOT NULL,
                               patronymic VARCHAR(250),
                               birthdate DATE,
                               group_number VARCHAR(7)
);