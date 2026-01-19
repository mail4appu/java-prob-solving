package test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainApp {
    private static final long MINUTES_5_IN_MILLIS = 1000 * 60 * 5;
    private static String VIOLATION_EVENT_NAVIGATOR_LINK = "https://${MsHost}/r1/activitylogs/logs?orignId=";

    public static void main(String[] args) {
        Long number =1l;
        number= null;
        long currentTimeMillis = System.currentTimeMillis();
        long fromDate = currentTimeMillis - MINUTES_5_IN_MILLIS;
        long toDate = currentTimeMillis + MINUTES_5_IN_MILLIS;
        StringBuilder violationEventLinkBuilder= new StringBuilder(VIOLATION_EVENT_NAVIGATOR_LINK);
        String url= violationEventLinkBuilder.append("123").append("&earliest=").append(fromDate).append("&latest=").append(toDate).toString();
        System.out.println(url);
        Set<Boolean> names= new LinkedHashSet<>();
        //names.add("Appu");

        boolean contextExceptionMatched=false;
        names.add(true && !contextExceptionMatched);
        names.add(true && contextExceptionMatched);
        System.out.println("Names "+names);


    }


}
