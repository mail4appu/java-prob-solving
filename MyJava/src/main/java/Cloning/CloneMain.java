package Cloning;

public class CloneMain {

	public static void main(String[] args) {

		try {
			Student s1= new Student(100, "Appu", new Department(10, "mechanical"));
			
			Student s2=(Student) s1.clone();
			System.out.println(s1.id+"   :  "+s1.name+"   :  "+s1.dept.deptName);
			System.out.println(s2.id+"   :  "+s2.name+"   :  "+s2.dept.deptName);
			s2.id=101;
			s2.dept.deptName="csc";
			System.out.println(s2.id+"   :  "+s2.name+"   :   "+s2.dept.deptName);
			
			System.out.println(s1.id+"   :  "+s1.name+"   :   "+s1.dept.deptName);
			if(s1==s2){
				System.out.println("both the objects are equal");
				
			}
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
