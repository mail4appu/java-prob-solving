package CompareClass;

import java.util.Comparator;

public class MarksComparator implements Comparator<Student>
{
	public int compare(Student st1, Student st2) 
	  {
	
	    return st1.getMarks() - st2.getMarks();
	  }
}
