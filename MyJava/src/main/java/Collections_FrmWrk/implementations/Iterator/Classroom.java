package Collections_FrmWrk.implementations.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Classroom implements Iterable<Student>{
	
	List<Student> students= new ArrayList<Student>();
	public Classroom(List<Student> students) {
     this.students=students;
	}

	public Iterator<Student> iterator() {
		
		return new ClassroomIterator(this);
	}

}
