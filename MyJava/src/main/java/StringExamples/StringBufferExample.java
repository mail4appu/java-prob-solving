package StringExamples;

/**
 * @author vapparao
 * 
 * StringBuffer comes with defualt buffer size 16. 
 * So if you append "some string", each character is placed in character array. Actullay StringBuffer 
 * is Sequence of Characters i.e characterArray
 * 
 * 
 * every new character is appended at the end of the last character in the array
 * if we add 17 the element, the buffer will check for next availbale space of generally 32 bit
 * 
 * 
 * in Non threaded/single threaded environment StringBuilder is used instead of StringBuffer
 * 
 * StringBuffer or builder has threee important methods, i.e append, insert and reverse( air)
 *
 * StringBuffer sb = new StringBuffer("appu"); --> IN the memory Array of size is 20 created
 * String s="Appu" -> In the memory array of size 4 is created
 *
 *
 */
public class StringBufferExample {
	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer(); //capacity 16
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.append("appu"); //capacity 16
		System.out.println(sb.capacity());
		sb.append("bujji");
		sb.append("syamu");
		sb.append("sidduga");
		StringBuffer sb2=new StringBuffer("appu"); //capacity 20
		sb2.append("poori");
		System.out.println("sb"+sb.capacity());
		System.out.println("sb:   "+sb2.capacity());
		
	}

}
