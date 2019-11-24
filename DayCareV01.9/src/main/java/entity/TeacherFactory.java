package entity;

public class TeacherFactory extends AbstractPersonFactory {

	@Override
	public Person getObject() {
		// TODO Auto-generated method stub
		return new Teacher();
	}

}
