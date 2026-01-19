package Collections_FrmWrk.implementations.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ClassromIteratorMain {
	public static void main(String[] args) {
		List<Student> students= new ArrayList<Student>();
		Student std1= new Student();
		std1.setName("abc");
		students.add(std1);
		Student std2= new Student();
		std1.setName("xyz");
		students.add(std2);
		Classroom cr= new Classroom(students);
		for(Student st:cr){
			System.out.println(st);
		}
		
		
	}

}
