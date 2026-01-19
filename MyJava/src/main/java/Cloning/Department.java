package Cloning;

public class Department implements Cloneable{
	int deptNo;
	String deptName;
	public Department(int deptId, String name) {
     this.deptName=name;
     this.deptNo=deptId;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
