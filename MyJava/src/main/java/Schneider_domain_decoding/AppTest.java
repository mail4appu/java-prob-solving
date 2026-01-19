package Schneider_domain_decoding;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AppTest {
    public static void main(String[] args) {
       /* String dateStr="2021-09-07T12:26:49.777Z";
        String dateStr2="2021-09-07 12:26:49.800";
        String z = dateStr.replace("T", " ").replace("Z", "");


        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss")
                .appendFraction(ChronoField.MILLI_OF_SECOND, 2, 3, true).toFormatter();
        LocalDateTime first = LocalDateTime.parse(z, formatter);
        LocalDateTime second = LocalDateTime.parse(dateStr2, formatter);
        System.out.println(first.isBefore(second));

        Map<String, String> finalMap= new HashMap<>();
        Map<String, String> firstMap= new HashMap<>();
        firstMap.put("Andhra", "Vizag");
        finalMap.putAll(firstMap);

        Map<String, String> secondMap= new HashMap<>();
        secondMap.put("Telangana", "Hyderabad");
        finalMap.putAll(secondMap);

        finalMap.entrySet().stream().forEach(System.out::println);

        String url="https://les-d-1.les-use2.sasedev.flexilis.com/cdr/content/_FILE_PATH_";
        System.out.println(url.indexOf("_FILE_PATH_"));
        url= url.replace("_FILE_PATH_", "");
        System.out.println(url);*/
        Optional<String> optional = Optional.ofNullable("Appu");


    }

}

