package IFELSE;

/**
 * @author vapparao
 *
 *if, else-if only one of the statement is checked
 *in case of two ifs, both the coditions are chacekd
 *
 *
 */
public class IfelseTest {
	public static void main(String[] args) {
		int a=1;
		if(a==1){ //a==1, this is checked
			System.out.println("a is: "+a);
		}
		else if(a==1){ //though a is 1, as if statement is executed, this statment will not be executed . Else if statements are executed only the
			           //above if or else if statement is false
			System.out.println("a* is:  "+a);
		}
	}

}
