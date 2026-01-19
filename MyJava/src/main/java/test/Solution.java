package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("input the no of integers\n");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("input the series \n");
		sc.nextLine();
        String series= sc.nextLine();
        if(series!=null){
        System.out.println("Entered series is:"+series);
        String []input= series.split(",");
        int diff=0;
        int []seriesInput= new int[input.length+1];
        if(n>=3 && n<=2500){
        	for(int i=0;i<input.length;i++){
        		seriesInput[i]= Integer.parseInt(input[i].trim());
        	}
        	
        	diff=getProgressionDiff(seriesInput);
        	System.out.println("diff is"+diff);
        	for(int j=0;j<seriesInput.length+1;j++){
        		if(j+1<seriesInput.length && seriesInput[j]-seriesInput[j+1]==diff){
        			continue;
        		}
        		else{
        			if(j+1<seriesInput.length)
        			seriesInput[j+1]=seriesInput[j]+diff;
        		}
        	}
        	
        }
        System.out.println(Arrays.toString(seriesInput));
        
	}
	}
	
	private static int getProgressionDiff(int []input){
		
		int firstTwoDiff=input[1]-input[0];
		System.out.println(firstTwoDiff);
		int lastTwoDiff=input[input.length-2]-input[input.length-1];
		System.out.println(lastTwoDiff);
		
		if(firstTwoDiff==lastTwoDiff){
			return firstTwoDiff;
		}
		else{
			return input[4]-input[3];
		}
	}

}
