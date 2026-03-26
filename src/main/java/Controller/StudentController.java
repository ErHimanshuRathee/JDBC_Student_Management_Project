package Controller;

import java.util.Scanner;

import DAO.StudentDao;
import DTO.Student;

public class StudentController {

	public static void main(String[] args) {

		StudentController controller = new StudentController();
		StudentDao sDaoFinal = new StudentDao();
		Scanner sc = new Scanner(System.in);
		Student student;
		int rollNo;
		String name;
		String course;
		String address;

		System.out.println("Please choose 1 operation from below:" + "\n 1. Display all student."
				+ "\n 2. Add new Student" + "\n 3. Update Student based on Roll No." + "\n 4. Search by rollNo."
				+ "\n 5. Search students by name" + "\n 6. delete student by roll No." + "\n 7. EXIT");

		int finalSet = sc.nextInt();

		while (finalSet != 7) {
			if (finalSet == 1) {
//		1. Display all student.
				sDaoFinal.displayAllStudentsDao();

			}

			else if (finalSet == 2) {
//		2. Add new Student
				System.out.println("Student Addition form:");
				System.out.println("Please enter Roll No:");
				rollNo = sc.nextInt();
				System.out.println("Please enter Name:");
				name = sc.next();
				System.out.println("Please enter Course:");
				course = sc.next();
				System.out.println("Please enter Address:");
				address = sc.next();

				student = new Student(rollNo, name, course, address);

				System.out.println(student.toString());
				sDaoFinal.addStudentDao(student);

			}

			else if (finalSet == 3) {
//		3. Update Student based on Roll No.
				System.out.println("Student updation form:");
				System.out.println("Please enter Roll No. wanted to be update:");
				rollNo = sc.nextInt();
				System.out.println("Please enter updated Name:");
				name = sc.next();
				System.out.println("Please enter updated Course:");
				course = sc.next();
				System.out.println("Please enter updated Address:");
				address = sc.next();

				student = new Student(rollNo, name, course, address);

				System.out.println(student.toString());
				sDaoFinal.modifyStudentDao(student);

			}

			else if (finalSet == 4) {

//		4. Search by rollNo.
				System.out.println("Search student using roll No.");
				System.out.println("Please enter rollNo to fetch:");
				rollNo = sc.nextInt();

				sDaoFinal.searchStudentByrollNoDao(rollNo);
			}

			else if (finalSet == 5) {

//		5. Search students by name
				System.out.println("Search students by Name");
				name = sc.next();
				sDaoFinal.searchStudentByNmeDao(name);
			}

			else if (finalSet == 6) {

//		6. delete student by roll No.
				System.out.println("Deletion data:");
				System.out.println("Please enter roll No. to delete");
				rollNo = sc.nextInt();
				sDaoFinal.deleteStudentByrollNoDao(rollNo);
			}
			
			
			System.out.println("Please choose 1 operation from below:" + "\n 1. Display all student."
					+ "\n 2. Add new Student" + "\n 3. Update Student based on Roll No." + "\n 4. Search by rollNo."
					+ "\n 5. Search students by name" + "\n 6. delete student by roll No." + "\n 7. EXIT");

			  finalSet = sc.nextInt();

		}

	}

}
