package Oops.inheritance;

public class MainSuperSub {

	public static void main(String[] args) {
		SubClass sb1= new SubClass();
		Subclass2 sb2= new Subclass2();
		//sb1=sb2;
		SuperClass sup= new SuperClass();
			System.out.println();
			//System.out.println(sup.y);
			System.out.println("*********"+new MainSuperSub().getValue());
	}

	public int  getValue() {
		int i=0;
		try{
		int d=10/1;
		System.out.println("try block");
		System.exit(0);
		return i;
		
		}catch(Exception e){
			i=200;
			return i;
		}
		finally{
			System.out.println("Finally returning");
			i=300;
			return i;
		}
	}
}
