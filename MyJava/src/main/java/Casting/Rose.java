package Casting;

public class Rose extends Flower{
	public void smell()
	  {
	    System.out.println("Rose gives rosy smell");
	  }
	   public static void main(String args[])
	   {
	    
	     Flower f = new Flower();

	     Rose r= new Rose();
	     f = r;  //implicit casting should be done before doing explicit casting....here comment this stmt
	     		//and see the exception at line 18 i.e RunTimeException but not compileTimeException
	     f.smell();		// II
	     
	 
	  // r  = f;             // super class to subclass, not valid
	     r = (Rose) f;	  // explicit casting
	     f.smell();		// II
	 
	   }

}
