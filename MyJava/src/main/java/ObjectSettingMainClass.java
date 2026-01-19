

public class ObjectSettingMainClass {
	public static void main(String args[]){
		Person p= new Person();
		EmployeeType emptype= new EmployeeType();
		emptype.setDept("Mechanical");
		emptype.setName("Appu");
		Employment emp= new Employment();
		emp.setEmptype(emptype);
		
		
	}

}
