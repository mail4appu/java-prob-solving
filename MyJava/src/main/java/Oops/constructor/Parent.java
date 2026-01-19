package Oops.constructor;

/**
 * @author Test
 * 
 * Default constructor is added only when we dont define either no-arg or arg constructor
 * 
 * The job of default constructor is to call super(). Nothing more than this.*****
 * 
 * When we define our own constructor, default constructor is not added any more but a call to super() is added in user defined constructor.
 * 
 * So in any constructor( default/custom) first statement is call to super() by default. *******
 * 
 * There are no restrictions like, super() is not added in any scenario. No-arg super is always added in any constructor
 * 
 * we never write super() call, unless we want to call argumented constructor
 * 
 * Private constructor means, we can not create object anywhere outside the class
 * 
 *
 */
public class Parent {
	public Parent(){
		System.out.println("inside parent constrcutor");
	}
	public void display(){
		System.out.println("in parent display");
	}


	public void callMethod(){
		display();
	}
}
