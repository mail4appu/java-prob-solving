package test;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppTest {

    public static void main(String[] args){
        List<String> strings = Arrays.asList("123", "345");
        String []numbers={"abc", "def"};
        System.out.println(Arrays.toString(numbers));

        List<String> testStrings= new ArrayList<>();
        testStrings.addAll(null);

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] names={"appu", "poori", "bujjamma","sneha"};
        List<int[]> numberList=Arrays.asList(number);
        List nameList=Arrays.asList(names);
        System.out.println("List of String objects: "+nameList);
        System.out.println("List of primitives: "+numberList);
        List<String> strings_alt = Arrays.asList("xyz", "wer");
        System.out.println(5==10);


        //STREAMS
        final IntStream intStream = IntStream.of(1, 1,1, 1,2, 3, 4,4,5,5,5);
        final Map<Integer, Long> collect = intStream.boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().stream().forEach(item-> System.out.println(item.getKey()+"    "+item.getValue()));
        Long along=collect.entrySet().stream().map(Map.Entry::getValue).findFirst().orElse(null);
        System.out.println(along);

        strings.addAll(null);

        String fileName="\\\\/ciphercloud\\\\/data\\\\/downloads\\\\/REST\\\\/dqtdc2\\\\/93066750802\\\\/___\\\\/719099071901825\\\\/ccaip.SSNFile1.pdf\\";
        fileName=fileName.substring(fileName.indexOf("ccaip.")+6);
        fileName=fileName.replace("\\", "");
        System.out.println(fileName);


    }
}

