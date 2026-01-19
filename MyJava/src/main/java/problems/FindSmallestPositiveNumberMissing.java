package problems;

import java.util.Arrays;
import java.util.Scanner;

public class FindSmallestPositiveNumberMissing {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array Size");
        int size=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter array");
        int[] numbers= new int[size];
        for(int i=0;i<size;i++){
            numbers[i]=sc.nextInt();
        }
        sc.nextLine();

        findSmallestPositiveMissingNumber(numbers);
    }

    private static void findSmallestPositiveMissingNumber(int[] input) {
        //Shift all negative numbers to left
        int j=0;
        for(int  i=0;i<input.length;i++){
            if(input[i]<=0){
                int temp=input[i];
                input[i]=input[j];
                input[j]=temp;
                j++;
            }

        }
        System.out.println(Arrays.toString(input));

        System.out.println(findMissingPositive(input, 4));


    }

    static int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++)
        {
            int x = Math.abs(arr[i]);
            if(x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes
        // start from 0

        return size+1;
    }
}
