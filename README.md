# JDBC_Student_Management_Project

# Student Management System (JDBC)

This is a simple Java project for managing student data using JDBC and MySQL.
The project was made for learning and assignment purposes.

The program runs in the console and allows basic operations like adding,
updating, searching, and deleting student records.

## Features

1. Display all students
2. Add a new student
3. Update student details using Roll No
4. Search student by Roll No
5. Search students by name
6. Delete student by Roll No

## Project Structure

Controller
- StudentController.java (Main class that runs the program and takes user input)

DAO
- StudentDao.java (Contains database operations like insert, update, delete, search)

DTO
- Student.java (Student object with fields like rollNo, name, course, address)

## Database

Database Name: JDBC_CRUD

Table: student_management

Columns:
- rollNo (int)
- name (varchar)
- course (varchar)
- address (varchar)

Example SQL:

CREATE TABLE student_management (
rollNo INT PRIMARY KEY,
name VARCHAR(50),
course VARCHAR(50),
address VARCHAR(100)
);

## How to Run

1. Import the project into Eclipse or any Java IDE.
2. Add MySQL Connector JAR to the project.
3. Create the database and table in MySQL.
4. Update database username and password in the connection class.
5. Run StudentController.java.
6. Choose options from the menu in the console.

## Purpose of the Project

This project was created to understand:
- JDBC connection
- CRUD operations
- DAO and DTO structure in Java
- Console based Java applications

## Author

Himanshu Rathi

