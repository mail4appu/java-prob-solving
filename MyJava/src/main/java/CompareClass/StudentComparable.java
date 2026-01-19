package CompareClass;

public class StudentComparable implements Comparable<StudentComparable>{
	private int marks;
	private String name;
    private String city;
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	  
 public int compareTo(StudentComparable st1){
	 return this.marks-st1.getMarks();
 }
	
	StringBuilder sb= new StringBuilder();
  public String toString(){
	  sb.append("\tMarks:"+marks);
	  sb.append("\tName:"+name);
	  sb.append("\tCity:"+city);
	  sb.append("\n");
	  return sb.toString();
	  
  }
}
