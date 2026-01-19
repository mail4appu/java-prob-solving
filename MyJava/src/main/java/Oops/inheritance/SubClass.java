package Oops.inheritance;

/**
 * @author vapparao
 * 
 * subclass can extend its features apart from having base class featrues
 * 
 * 
 * so a extends b  implies   "a is subclass and b is superclass"
 * 
 * Difference between Aggregation and composition 
 * http://www.apwebco.com/aggregation/AggregationComposition.html
 * http://usna86-techbits.blogspot.in/2012/11/uml-class-diagram-relationships.html
 * 
 *
 */
public class SubClass extends SuperClass{
	
	public SubClass() {
		System.out.println("subclass constructor");
	}
    //here y is inherited from superclass but we are hiding that and giving our own value
    int y=200;	
	public SubClass(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	public void show(int x, int y){
		System.out.println("subclass x vlaue"+x);
		//static method that is inherited
		//display();
	}
	
	 private String run(){
		System.out.println("subclass is running");
		return "";
	}
	
	public void print(){
		System.out.println("subclass1 is printing");
	}
	
	
	
}
