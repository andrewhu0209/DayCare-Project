package entity;

public class UserFactory extends AbstractPersonFactory{

	@Override
	public Person getObject() {
		// TODO Auto-generated method stub
		return new User();
	}

}
