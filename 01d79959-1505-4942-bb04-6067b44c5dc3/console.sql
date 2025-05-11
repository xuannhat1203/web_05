create database studentsData;
use studentsData;
CREATE TABLE students
(
    id      INT PRIMARY KEY,
    name    VARCHAR(100),
    age     INT,
    address VARCHAR(100)
);
INSERT INTO students (id, name, age, address)
VALUES (1, 'Nguyen Van A', 20, 'Ha Noi'),
       (2, 'Tran Thi B', 21, 'Hai Phong'),
       (3, 'Le Van C', 19, 'Da Nang'),
       (4, 'Pham Thi D', 22, 'TP Ho Chi Minh'),
       (5, 'Hoang Van E', 20, 'Can Tho'),
       (6, 'Vu Thi F', 23, 'Hue'),
       (7, 'Do Van G', 20, 'Bac Ninh'),
       (8, 'Mai Thi H', 21, 'Nam Dinh'),
       (9, 'Dang Van I', 19, 'Quang Ninh'),
       (10, 'Nguyen Thi J', 22, 'Vinh');

delimiter \\
CREATE PROCEDURE delete_student_by_id(IN studentId INT)
BEGIN
    DELETE FROM students WHERE id = studentId;
END;
CREATE PROCEDURE update_student_by_id(
    IN studentId INT,
    IN studentName VARCHAR(100),
    IN studentAge INT,
    IN studentAddress VARCHAR(255)
)
BEGIN
    UPDATE students
    SET name    = studentName,
        age     = studentAge,
        address = studentAddress
    WHERE id = studentId;
END;
drop procedure get_student_by_page;
DELIMITER //
CREATE PROCEDURE get_student_by_page(IN page INT, IN size INT)
BEGIN
    SELECT * FROM students
    LIMIT size OFFSET page;
END //
DELIMITER ;
delimiter \\
create procedure get_all_student()
begin
    select count(id) from students;
end \\
delimiter \\;
create table Categories (
    catalog_id int primary key auto_increment,
    catalog_name varchar(255) not null unique ,
    catalog_description text,
    catalog_status bit
);
delimiter \\
create procedure find_all_categories()
begin
    select *from categories;
end \\
delimiter \\;
delimiter \\
create procedure save_catalog(
    name_in varchar(255),
    des_in varchar(255),
    status_in bit
)
begin
    insert into Categories(catalog_name, catalog_description, catalog_status)
        values (name_in,des_in,status_in);
end \\
delimiter \\;
drop procedure find_all_categories;
drop procedure save_catalog;

