import java.lang.reflect.Array;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


public class RemovalFromArray {
   
	/**
	 * @param args
	 */
	public static void main(String args[]){
		long intialTime= System.currentTimeMillis();
		int[] numbers={1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32, 1,4, 5, 3, 19, 1, 3, 32, 56, 32, 56, 32, 59, 89, 89, 78, 56, 1, 19, 1, 4, 5, 3, 19, 56, 32};
		Arrays.sort(numbers);
		//System.out.println(""+Arrays.toString(numbers));
		
		int[] uniqueNumbers= new int[numbers.length];//if you modify above array, give the length of above array to this 
		//System.out.println(uniqueNumbers.length);
		uniqueNumbers[0]=numbers[0];
		int j=1;
		for(int i=1;i<numbers.length && j<numbers.length;i++){
			
				if(numbers[i-1]!=numbers[i]){
					uniqueNumbers[j]=numbers[i];//u cna use binary search also
					j=j+1;
					
				
			}
				
		}
		int finalNumbers[]= new int[j];
		System.arraycopy(uniqueNumbers, 0, finalNumbers, 0, j);
		System.out.println("time taken to remvoe"+(System.currentTimeMillis()-intialTime));
		/*System.out.println(Arrays.toString(uniqueNumbers));
		System.out.println("size of unique array"+uniqueNumbers.length);*/
		System.out.println("final array"+Arrays.toString(finalNumbers));
	}

}
