package leatcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the partition technique used in quick sort
 * Here take the pivot element as 0
 *
 * https://www.youtube.com/watch?v=MZaf_9IZCrc
 */
public class MoveAllNegativeElements {
    public static void main(String[] args) {
        System.out.println("Please enter Array Size");
        Scanner scanner= new Scanner(System.in);
        int size=scanner.nextInt();
        int[] input= new int[size];
        System.out.println("Please enter array elements");
        for(int i=0;i<size;i++){
           input[i]=scanner.nextInt();

        }
        moveAllNegativeElements(input);
    }

    private static void moveAllNegativeElements(int[] input) {
        int j=-1;
        int temp=0;
        for(int i=0;i<input.length;i++){
            if(input[i]<0){
                j++;
                if(i!=j){
                  temp=input[i];
                  input[i]=input[j];
                  input[j]=temp;
                }
            }

        }
        System.out.println("Array is"+ Arrays.toString(input));
    }
}
