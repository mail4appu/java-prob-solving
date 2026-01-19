package algorithms.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Please enter size and list 1");
        List<Integer> list1= new ArrayList<>();
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            list1.add(sc.nextInt());
        }

        System.out.println("Please enter size and list 2");
        List<Integer> list2= new ArrayList<>();
        int size2=sc.nextInt();
        for(int i=0;i<size2;i++){
            list2.add(sc.nextInt());
        }

        printMergedList(list1, list2);

    }

    private static void printMergedList(List<Integer> arr1, List<Integer> arr2) {

        ArrayList<Integer> result= new ArrayList<Integer>();

        if(arr2==null){
            System.out.println(arr1);
        }
        if(arr1==null){
            System.out.println(arr2);
        }

        int i=0;
        int j=0;
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                result.add(arr1.get(i));
                i++;
            }
            else{
                result.add(arr2.get(j));
                j++;

            }



        }
        while(i<arr1.size()){
            result.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            result.add(arr2.get(j));
            j++;
        }
        System.out.println(result);
    }
}
