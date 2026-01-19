package Oops.inheritance;


/**
 * @author Test
 * Private members are not inherited
 * Constructors are not inherited. 
 * ******static members are  inherited ****
 * 
 * You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended)(java doc)
 *
 * Static methods are not overridden. Because overriding is concept related with objects. Where in static does not fit here.
 * 
 * If we define static method, with the same signature in subclass, it is like hiding the parent method. So this is called Method hiding in the subclass
 * 
 * Which static method is called when parent and child have same static method?
 * this is decided based on the type i.e reference type not by Obejct.
 * Just as how JVM decides which overloaded method is called
 *
 *
 */
public class SuperClass {
	
	private int x=100;
	protected int y;
	
	public SuperClass() {
		System.out.println("Super class constrcutor");
	}
    public SuperClass(int x){
    	this.x=x;
    }
	
	public void show(){
			System.out.println("super class x vlaue");
		}
	 /**
	 * @param x
	 * 
	 * Method signature=methodName+parameter only..it does not include return tpe
	 */
	public void show(int x){
			System.out.println("super class x vlaue"+x);
		}
	/* public int show(int x){ //if we uncomment this it will say duplicate method. Duplicate method= method signatures are same
		 return 1;
	 }*/
	
	 public void show(double x){//method over loading in the same class
			System.out.println("super class x vlaue"+x);
		}
	 public void show(Number x){
			System.out.println("super class x vlaue"+x);
		}
	
    protected  static void display(){
    	System.out.println("inside super calss static method");
    }
    
    private Object run(){
    	System.out.println("Super class is running");
    	return 0;
    }
    
    public void print(){
    	System.out.println("super is printing");
    }
	 
}
