package entity;

import java.text.ParseException;

public class StudentFactory extends AbstractPersonFactory {

	@Override
	public Person getObject() {
		// TODO Auto-generated method stub
		return new Student();
	
	}
	
	public Person getObject(int studentId, String name, int age, String parentsName, String address, String phone, int teacherId,
			String enrollDay, String nextEnrollDay, String enrollStatus, String hib6, String dtap6, String dtap15,
			String polio6, String polio15, String hepb6, String mmr12, String var12) throws ParseException {
		
		return new Student(studentId, name, age,  parentsName,  address,  phone,  teacherId,
				 enrollDay,  nextEnrollDay,  enrollStatus,  hib6, dtap6,  dtap15,
				 polio6,  polio15,  hepb6,  mmr12, var12);
	}

}
