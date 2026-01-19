package Collections_FrmWrk.implementations.Iterator;

import java.util.Iterator;
import java.util.List;

public class ClassroomIterator implements Iterator<Student>{
	List<Student> students;
    int index;
	
	public ClassroomIterator(Classroom classRoom) {
		this.students=classRoom.students;
	}

	public boolean hasNext() {
	     return index<students.size();	
	}

	public Student next() {
		
		return students.get(index++);
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
