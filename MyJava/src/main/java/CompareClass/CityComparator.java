package CompareClass;

import java.util.Comparator;

public class CityComparator implements Comparator<Student>{
	public int compare(Student st1, Student st2) 
	  {
	    return st1.getCity().compareTo( st2.getCity());
	  }

}
