package ExceptionHandling.trycatchfinally;

/**
 * @author apparao
 *
 * Any customized exception class that extends Exception is a checkedException
 * Any customized exception class that extends RuntimeException is a unchecked Exception
 * 
 * The only scenario, where finally can not executed is System.exit().
 * In all other scenarios finally wil be executed
 *  return, continue,  break statements dont have any effect on finally block
 *  
 *  
 *  if there is return statement in finally block Then return statement in try or catch block will have no effect.
 *  
 *  if there is no return statement in finally block then return statement in either try or catch is executed after finally block is executed completely
 *  
 *
 */
public class TryCatchFinallyTest {
	private static final String str="0.6t";
	public static void main(String[] args) throws Exception {
		
		System.out.println(testString());
	}
	@SuppressWarnings("finally")
	private static boolean testString() {
		try{
			int i=Integer.parseInt(str);
			return true;
			
		}catch(NumberFormatException ex){
			System.out.println("number format exception occurred");
			//System.exit(0); //After this finally will not be executed
			return false;
			
		}catch(Exception ex){
			System.out.println("number format exception occurred");
			return false;
			
		}finally{ //finally executes irrespective of anycode. whether exception is thrown or return statement added in try or catch block.
		      //So return statement in the finally is returned
		System.out.println("inside finally");
		return true;
	}
	}
	

}
