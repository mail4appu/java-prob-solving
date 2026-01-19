
public class StaticContent {
	static int count=0;//will get memory when instance is created

	StaticContent(){
	count++;
	System.out.println(count);
	}

	public static void main(String args[]){

		StaticContent c1=new StaticContent();
		StaticContent c2=new StaticContent();
		StaticContent c3=new StaticContent();


}
}
