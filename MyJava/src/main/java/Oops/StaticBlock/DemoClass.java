package Oops.StaticBlock;

public class DemoClass {
	 public DemoClass() {
		    System.out.println("AClass's Constructor");
		  }
		  static { //static block wil be executed only once thoough u create multiple objects
		    System.out.println("static block in AClass");
		  }

}
