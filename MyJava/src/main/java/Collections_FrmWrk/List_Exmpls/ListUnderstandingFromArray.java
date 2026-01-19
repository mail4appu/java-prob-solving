package Collections_FrmWrk.List_Exmpls;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Autoboxing works only on single element but not on array of elements
 * int[] input={15, 7, 4, -2, 89, 23};
 * List<Integer> intList = Arrays.asList(input);===> this gives compile time error
 *
 *
 *
 *
 */
public class ListUnderstandingFromArray {
    public static void main(String[] args) {
        int[] input={15, 7, 4, -2, 89, 23};

        String[] strInput={"appu", "sunni", "Jeswin"};
        List<String> stringList=Arrays.asList(strInput);
        System.out.println(stringList.size());
        //List<Integer> intList = Arrays.asList(input);
        List<Integer> intList = IntStream.of(input).boxed().collect(Collectors.toList());
        System.out.println(input);
        System.out.println(intList.size());
        System.out.println(intList.set(2, 17));
        System.out.println(intList);
        intList.add(35);
        System.out.println(intList);
        stringList.add("Rutwika");
        System.out.println(stringList);


    }
}
