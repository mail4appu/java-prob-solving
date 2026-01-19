package algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FindMaximumInWindow {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter array Size");
        int size = scanner.nextInt();
        System.out.println("Enter array elements");
        int[] input= new int[size];
        for(int i=0;i<size;i++){
            input[i]=scanner.nextInt();
        }
        System.out.println("Enter window size");
        int k=scanner.nextInt();
        scanner.nextLine();

        findMaxInWindow(findNextGreaterElement(input),input, k);





    }

    private static void findMaxInWindow(int[] nge, int[] input, int k) {
     int j=0;
     for(int i=0;i<input.length-k;i++){
         if(j<i){
             j=i;
         }
         while(nge[j]<i+k){
             j=nge[j];
         }
         System.out.println(input[j]);
     }

    }

    private static int[]  findNextGreaterElement(int[] input) {
        int[] nge=new int[input.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<input.length;i++){

            while(!stack.empty() && input[i]>input[stack.peek()]){
                nge[stack.pop()]=i;
            }
            stack.push(i);


        }
        System.out.println(Arrays.toString(nge));

        return nge;

   }
}
