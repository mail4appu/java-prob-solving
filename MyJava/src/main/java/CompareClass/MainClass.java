package CompareClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Test
 * 
 * 
 * For every element in the list, compare() method is called and sorted. We dont call the compare() method for every 
 * element of the list explicitly
 * 
 * Collections.sort(list, comparator)
 * 
 * For maps
 * 
 * SortedMap orderedMap= new TreeMap(compartor)
 * 
 * Here Map is given to ComparatorClass constructor and that comparator object is given to TreeMap
 * 
 * 
 *
 */
public class MainClass {
	public static  void main(String args[]){
		List<Student> studentList= new ArrayList<Student>();
		List<String>  list=new ArrayList<String>();
		list.add("appu");
		list.add("madhu");
		list.add("bujji");
		list.add("siddu");
		list.add("yadhi");
		list.add("suri");
		Collections.sort(list);
		System.out.println("SORTED ==========");
		
		//Collections.reverse(list);//reverses the list elements i.e back to front
		
		Collections.sort(list, Collections.reverseOrder());//it gets the elements in the alphabetically reverese order
		System.out.println("list"+list);
		TreeMap hm= new TreeMap();
		Student s1= new Student();
		s1.setCity("vizag");
		s1.setMarks(60);
		studentList.add(s1);
		Student s2= new Student();
		s2.setCity("hyderabad");
		s2.setMarks(100);
		studentList.add(s2);
		Student s3= new Student();
		s3.setCity("vijayawada");
		s3.setMarks(40);
		studentList.add(s3);
		Student s4= new Student();
		s4.setCity("pune");
		s4.setMarks(120);
		studentList.add(s4);
		hm.put(s1,"student1");
		hm.put(s2,"student2");
		hm.put(s3,"student3");
		hm.put(s4,"student4");
		System.out.println("treemap contains"+hm);
		
		MarksComparator mc=new 	MarksComparator();
		CityComparator cc=new 	CityComparator();
		Collections.sort(studentList, mc);
		Collections.sort(studentList, cc);//sort method always effects the original list
		for(int i=0;i<studentList.size();i++){
			System.out.println(studentList.get(i).toString());	
		}
		
		System.out.println(studentList);
		
		/*//using comparable
		List<StudentComparable> sclist=new ArrayList<StudentComparable>();
		StudentComparable sc1= new StudentComparable();
		sc1.setCity("vizag");
		sc1.setMarks(100);
		sclist.add(sc1);
		StudentComparable sc2= new StudentComparable();
		sc2.setCity("hyd");
		sc2.setMarks(70);
		sclist.add(sc2);
		Collections.sort(sclist);
		System.out.println(sclist);*/
	}

}
