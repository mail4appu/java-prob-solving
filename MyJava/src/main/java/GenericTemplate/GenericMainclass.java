package GenericTemplate;

public class GenericMainclass {
	public static void main(String args[]){
	MyClass<SuperClass> stringHolder = new MyClass<SuperClass>();
	SubClass subc= new SubClass();
	SuperClass supc= new SuperClass();
	stringHolder.setAnyObject(supc);
	stringHolder.inspect(0.005);
	
	System.out.println(stringHolder.getAnyObject().toString());
	

}
	
}