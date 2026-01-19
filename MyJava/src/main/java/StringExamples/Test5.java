package StringExamples;

import java.util.Arrays;

public class Test5 {
	public static void main(String[] args) {
		
		int [][] one=new int[][]{{1,2,3}, {4,5,6}};
		int [][]two= new int[3][2];
		
		for(int i=0;i<two.length;i++){
			for(int j=0;j<one.length;j++){
				two[i][j]=one[j][i];
			}
		}
		System.out.println(Arrays.toString(two));
	}
}
