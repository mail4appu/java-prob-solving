package Arrays;

/**
 * @author apparao
 * 
 * This method is best useful usign xor operator when a list contains
 * one unique element and rest of the elements are repeating
 * 
 * This works on the principal
 * x^x=0
 * x^y=z;
 * z^x=y;
 * y^z=x;
 *
 * 
 * 
 * 
 *
 */
public class SingleUniqueNumber {

	public static void main(String[] args) {
		int []input={6,5,5,3,3,4,9,9, 8, 8,6, 7, 7, 4,4};
		int n=0;
		for(int i=0;i<input.length;i++){
			System.out.println(n+"^"+input[i]+"=:   "+(n^input[i]));
			n=n^input[i];
		}
		System.out.println("Unique no"+n);
		
		
	}
	
}
