package algorithms.binarysearch;

import java.util.Scanner;

public class InsertionIndexForTopScores {
	static int  size;
	//keep changing this array elements to get right index for insertion
	static int []scores= new int[]{1, 4, 5, 9 ,12};

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter the score");
		int score=sc.nextInt();
		sc.nextLine();
		add(score);



	}
	private static void add(int score){

		int index=findIndexToInsert(scores, score);
		System.out.println("index @ which new element should be inserted"+index);
		scores[index]=score;
		size++;


	}
	private static int findIndexToInsert(int[] scores, int score) {
		int start=0;
		int size=scores.length;
		System.out.println("size of the array"+size+"  score: "+score);
		if(size==0){
			return 0;
		}
		int end=size-1;
		int mid=0;

		while(start<=end){
			mid=(start+end)/2;
			if(score<scores[mid]){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
		return score<=scores[mid]?mid:mid+1;


	}


}
