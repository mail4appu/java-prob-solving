package xor;

public class NumberOccurringOddTimes {
	public static void main(String[] args) {
		int input[]= {2,3,4,3,1,4,5,1,4,2,5};
        int result=0;
        for(int i=0;i<input.length;i++){
        	result=result^input[i];
        }
        System.out.println(result);
	}
}
