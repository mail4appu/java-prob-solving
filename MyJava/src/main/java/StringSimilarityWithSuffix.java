import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StringSimilarityWithSuffix {
	public static void main(String[] args) {
		System.out.println("Please enter no of test cases");
		Scanner sc = new Scanner(System.in);
        int res;

        int testCaseNo = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<testCaseNo; i++) {
            String str = sc.nextLine();
            res = getSuffixesAndSimilarity(str);
            System.out.println(res);
        }
	}
	static int getSuffixesAndSimilarity(String a) {
		List<String> suffixes=getSuffixes(a);
        

        return 0;
    }
	
	private static List<String> getSuffixes(String a){
		List<String> suffixes= new ArrayList<String>();
		for(int i=0;i<a.length();i++){
			suffixes.add(a.substring(i));
		}
		System.out.println(suffixes);
		return suffixes;
		
	}

}
