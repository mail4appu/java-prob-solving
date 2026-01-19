package StringExamples;

/**
 * @author apparao
 * 
 * The ways of creating String in java
 * 
 * String s= new String()
 * String s= new String("abc");
 * String s= new String(charArray); char[] charArray={'a', 'b', 'c'};
 * String s= new String(byteArray); byte[] byteArray={22, 23, 24}
 *                        |
 *                        |---This is how we pass arrays to constructor or methods
 *                        
 * String s= new String(sb); here sb is StringBuffer or StringBuilder
 * 
 *                       
 *                       
 *                       
 *  
 */
public class StringOperations {
	public static void main(String args[]){
		String s="hello";
		String s1=null;
		System.out.println(String.valueOf(s));//internally s.toString() wil be called
		System.out.println(String.valueOf(s1));//here s1 is an object.Hence Object.toString()is called
		System.out.println(String.valueOf(null));//here null.toString()=>NullPointerException
                                                 //NPE is thrown whn we perform operations on null   		
		
	}

}
