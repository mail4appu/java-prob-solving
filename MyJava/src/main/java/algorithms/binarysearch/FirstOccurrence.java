package algorithms.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class FirstOccurrence {
    public static void main(String[] args) {
        System.out.println("Please enter size of an array");
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter array elements");
        int []input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        sc.nextLine();
        Arrays.sort(input);
        System.out.println("Enter the key to search");
        int key=sc.nextInt();
        sc.nextLine();
        findFirstOccurrence(input, key);
    }

    private static void findFirstOccurrence(int[] input, int key) {
        int size=input.length;
        int start=0;
        int end=size-1;
        int mid=-1;
        while(start<=end){
             mid=(start+end)/2;
            if( input[mid]==key){
                end=mid-1;
            }
            else if(key>input[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }


        }

        System.out.println("First occurrence is"+mid);

    }
}
