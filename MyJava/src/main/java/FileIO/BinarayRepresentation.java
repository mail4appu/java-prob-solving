package FileIO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BinarayRepresentation {
	public static void main(String[] args) {
		String s = "admin";
		byte[] bytes;
		try {
			bytes = s.getBytes("US-ASCII");
			System.out.println(""+Integer.toString(5, 2));
			System.out.println(Arrays.toString(bytes));
			System.out.println();
			String str = Integer.toBinaryString("a".getBytes("UTF-8")[0]);
		    System.out.println(Arrays.toString("123".getBytes("UTF-8")));


		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
