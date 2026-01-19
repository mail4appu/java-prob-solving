package Cloning;

import GenericTemplate.SuperClass;

/**
 * @author appu
 * 
 * http://howtodoinjava.com/core-java/cloning/a-guide-to-object-cloning-in-java/
 * 
 * With super.clone() only reference of the member class will be copied. 
 * 
 * 
 * Default cloning is Shallow cloning in java. i.e 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class Student implements Cloneable{
	int id;
	String name;
	Department dept;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	public Student(int id, String name, Department dept) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.dept=dept;
	}
	
	
	/*public Object clone() throws CloneNotSupportedException{
		//return new Student(this.id, this.name, this.dept);
		
		return super.clone();
	}*/

	
	public Object clone() throws CloneNotSupportedException{
		
		
		Student cloned=(Student)super.clone();
		//Here we are setting the cloned department to the cloned student.  Now two different departments for two different students.
		cloned.setDept((Department)cloned.getDept().clone());
		return cloned;
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

}
