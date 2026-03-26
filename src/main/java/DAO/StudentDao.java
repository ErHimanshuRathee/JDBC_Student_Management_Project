package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.Student;

public class StudentDao {

	static Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	String fetchAllStudents = "select * from student_management";

	// connection establish
	public static Connection getConnectionDao() {
		try {
			// sometime these doesn't work
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/JDBC_CRUD";
			String name = "root";
			String pass = "himanshu";

			connection = DriverManager.getConnection(url, name, pass);

		} catch (Exception e) {
			System.out.println("Message  = " + e);
			return null;
		}

		return connection;
	}

	public void displayAllStudentsDao() {
		try {
//			StudentDao sDao = new StudentDao();
			getConnectionDao();
			statement = connection.createStatement();
			rs = statement.executeQuery(fetchAllStudents);
			while (rs.next()) {
				System.out.println("---------------------------");
				System.out.println("Roll No. = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("Course = " + rs.getString(3));
				System.out.println("Address = " + rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStudentDao(Student student) {
		int rollNo = student.getRollNo();
		String name = student.getName();
		String course = student.getCourse();
		String address = student.getAddress();
		try {
			getConnectionDao();
			ps = connection.prepareStatement("insert into student_management values(?,?,?,?)");

			ps.setInt(1, rollNo);
			ps.setString(2, name);
			ps.setString(3, course);
			ps.setString(4, address);

			ps.executeUpdate();
			System.out.println("New Student Added successfully...");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyStudentDao(Student student) {
		try {
			getConnectionDao();
			ps = connection
					.prepareStatement("update student_management set name=?, course=?, address=? where rollNo = ?");

			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setString(3, student.getAddress());
			ps.setInt(4, student.getRollNo());

			ps.executeUpdate();
			System.out.println("Student data updated for " + student.getRollNo());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void searchStudentByrollNoDao(int rollNo) {
		try {
			getConnectionDao();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from student_management where rollNo=" + rollNo);
			while (rs.next()) {
				System.out.println("---------------------------");
				System.out.println("Roll No. = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("Course = " + rs.getString(3));
				System.out.println("Address = " + rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	public void searchStudentByNmeDao(String name) {
		try {
			getConnectionDao();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from student_management where name like '%"+name+"%'");
			while (rs.next()) {
				System.out.println("---------------------------");
				System.out.println("Roll No. = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("Course = " + rs.getString(3));
				System.out.println("Address = " + rs.getString(4));
			}
		
		} catch (Exception e) {
System.out.println(e);
		}
	}
	
	
	public void deleteStudentByrollNoDao(int rollNo) {
		try {
			getConnectionDao();
			statement = connection.createStatement();
			boolean check = statement.execute("delete from student_management where rollNo=" + rollNo);
			System.out.println("Deleted student = " + rollNo);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
