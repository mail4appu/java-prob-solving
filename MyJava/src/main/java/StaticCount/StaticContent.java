package StaticCount;

/**
 * @author vapparao
 *  Static member is the common property of all objects.
 *  
 *  In java there is no global declaration. But we can achieve this
 *  by declaring static fields.
 *  
 *  As the static fields can be shared across all the object instances of an application, we can say
 *  static variable as global to that application.
 *  
 *  This global variable declaration can be used to implement caching mechanism in java.
 *  
 *  Other variables global to an application are application scoped i.e servletContext. one per we application
 *  
 *  or Singleton beans from Spring are also global to application.
 *  
 *  
 *  We can use third party caching mechanisms too
 *  Apache caching mechanism and  Squid are some examples
 *  
 *  
 *   
 *  
 *  
 *  
 */
public class StaticContent {
	static int count=0;//will get memory when instance is created
	/*public static void  getcount(){
     System.out.println("count valu is "+StaticContent.count);
     StaticContent.count=count++;


}*/
	StaticContent(){
		getStaticContent();	
	}
	public void getStaticContent(){
		
		System.out.println("count value is"+count);
		count++;
		
		
	}
	public int getcount(){
		return count;
	}
}
