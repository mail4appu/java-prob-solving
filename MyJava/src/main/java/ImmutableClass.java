import java.util.Date;


public class ImmutableClass {
	private final String firstName;
	private String lastName;
	
     
	
	public ImmutableClass(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	

	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	

}
