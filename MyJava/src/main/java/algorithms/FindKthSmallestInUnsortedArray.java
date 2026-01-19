package algorithms;

import java.util.Scanner;

public class FindKthSmallestInUnsortedArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter Array Size");
        int n=sc.nextInt();
        int[] input= new int[n];
        for(int i=0;i<n;i++){
            input[i]=sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter k value");
        int k=sc.nextInt();
        findKthSmallest(input, k);

    }

    static int ceil=Integer.MAX_VALUE;
    private static void findKthSmallest(int[] input, int k) {
        int floor=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
           ceil(input, floor);
           floor=ceil;
           ceil=Integer.MAX_VALUE;
        }

        System.out.println("kth smallest"+floor);

    }

    private static void ceil(int[] input, int floor) {
        for(int val:input){
            if(val>floor){
                if(val<ceil){
                    ceil=val;
                }
            }
        }

    }
}
