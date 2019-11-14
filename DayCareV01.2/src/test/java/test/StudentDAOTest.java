package test;

import java.util.List;

import dao.StudentDAO;
import entity.Student;

public class StudentDAOTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentDAO sDAO = new StudentDAO();
		List<Student> students = sDAO.findAll();
		
		for (Student s : students) {
			System.out.println(s.getStudentId());
		}
		
		


	}

}
