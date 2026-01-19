import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class TestClass {
	public static void main(String[] args) throws Exception{
		System.out.println("Please enter n and k values ");
		Scanner sc= new Scanner(System.in);
		String firstLine=sc.nextLine();
		//reading the inputs
		int n =Integer.parseInt(firstLine.split("\\s+")[0]);
		int k=Integer.parseInt(firstLine.split("\\s+")[1]);
		//Constraint validation
		if((n<0 || n>Math.pow(10, 5)) && (k<0 || k>Math.pow(10, 9))){
			
			throw new Exception("Please enter the valid inputs");
		}
		System.out.println("Please enter the series");
		//reading the series
		String secondLine= sc.nextLine();
		System.out.println(firstLine+"    "+secondLine);
		//Converting the series to integer series
		List<Integer> series=getIntSeries(secondLine, n);
		
		System.out.println(series);
		//Sorting the integer series
		Collections.sort(series);
		//Getting the no of pairs and printing
		System.out.println("No of pairs are: "+getNoOfPairs(series, k));




	}
	private static List<Integer> getIntSeries(String input, int size) throws Exception{
		List<Integer> series= new ArrayList<Integer>();
		String []strInput=input.split("\\s+");
		if(strInput.length!=size){
			throw new Exception("invalid series");
		}
		for(String s:input.split("\\s+")){
			series.add(Integer.parseInt(s));

		}
		return series;
	}


	private static int getNoOfPairs(List<Integer> series, int diff){
		int count=0;
		System.out.println(series);
		for(int i=0;i<series.size(); i++){
			for(int j=i+1;j<series.size();j++){
				if(series.get(j)-series.get(i)<diff){
					continue;
				}
				else if(series.get(j)-series.get(i)==diff){
					count++;
				}
				else{
					break;
				}
			}
		}
      return count;

	}
}
