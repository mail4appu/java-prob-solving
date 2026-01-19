
public class Person {
	private EmployeeType emptype=null;
	private String color=null;
	public EmployeeType getEmptype() {
		return emptype;
	}
	public void setEmptype(EmployeeType emptype) {
		this.emptype = emptype;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean equals(Object o){
	 	Person p= (Person)o;
		return this.color.equals(p.color);
	}
	

}
