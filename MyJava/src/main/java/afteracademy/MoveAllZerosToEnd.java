package afteracademy;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
      ArrayList<Integer> numbers= new ArrayList<>();
      numbers.add(0);
      numbers.add(1);
      numbers.add(0);
      numbers.add(3);
      numbers.add(1);
      numbers.add(2);
      moveZeroes(numbers);
        System.out.println(numbers);
        String s = StringUtils.removeEnd("", ",");
        "".substring(0, -1);
        System.out.println(s);

    }



    public static ArrayList<Integer> moveZeroes(ArrayList<Integer> arr) {
        int i=0, j=0;
        while(i<arr.size()){
            if(arr.get(i)!=0){
                int first=arr.get(i);
                int second=arr.get(j);
                int temp=first;
                arr.set(i, second);
                arr.set(j, temp);
                j++;
            }
            i++;

        }
        return arr;

    }
}
