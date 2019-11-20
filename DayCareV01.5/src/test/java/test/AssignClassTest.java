package test;

import java.util.List;

public class AssignClassTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<entity.Class> list= entity.Class.assignClass();
		for (entity.Class c : list) {
			System.out.println(c);
		}
		
		System.out.println("Sucess");

	}

}
