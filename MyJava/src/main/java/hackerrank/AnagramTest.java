package hackerrank;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class AnagramTest {

	public static void main(String[] args) {
		System.out.println("Please enter no of test cases ");
		Scanner sc= new Scanner(System.in);
		int length=sc.nextInt();
		sc.nextLine();
		if(length>=1 || length<=10){
			System.out.println("Please enter series");
			for(int i=0;i<length;i++){
				String[] input=sc.nextLine().split("\\s+");
				System.out.println(checkAnagram(input));
			}
		}
		else{
			System.out.println("Not a valid test case no");
		}
	}
	
	private static String checkAnagram(String[] input){
		if(input.length>500000){
			System.out.println("Please enter valid string");
		}
		else{
			String a1= input[0];
			String a2=input[1];
			if(a1.length()!=a2.length()){
				return "NO";
			}
			else{
				
				Map<Character, Integer> myMap1=prepareOccurances(a1);
				Map<Character, Integer> myMap2=prepareOccurances(a2);
				Set keySet=myMap1.keySet();
				Iterator it= keySet.iterator();
				while(it.hasNext()){
					if(!myMap1.get(it.next()).equals(myMap2.get(it.next()))){
						return "NO";
					}
					else{
						return "YES";
					}
				}
			}
		}
		
		return "NO";
	}

	private static Map<Character, Integer> prepareOccurances(String a1) {
		Map<Character, Integer> myMap= new HashMap<Character, Integer>();
		for(int i=0;i<a1.length();i++){
			int val=0;
			if(myMap.containsKey(a1.charAt(i))){
			    val=myMap.get(a1.charAt(i));
				myMap.put(a1.charAt(i),val+1);
			}
			else{
				myMap.put(a1.charAt(i), 1);
			}
			 
		}
		return myMap;
	}
}
