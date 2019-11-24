package test;

import entity.Student;

public class AgeCountTest {
	public static void main(String[] args) throws Exception {
		
		int[] age = Student.getAgeCount();
		
		for (int i : age) {
			System.out.println(i);
		}
	}

}
