package StringExamples;

import java.util.Arrays;

public class StringOccurances {
	public static void main(String[] args) {
		String str = "my place is vizag and is good and is awsomeis";
		String findStr="is";
		System.out.println(Arrays.toString(str.split(findStr)));
		System.out.println(str.split(findStr).length);
		
	}

}
