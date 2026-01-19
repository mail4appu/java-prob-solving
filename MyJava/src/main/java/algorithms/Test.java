package algorithms;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Test {

	
	public static void main(String... args) { 
        Set<Integer> nodeSet = new HashSet<Integer>();
        nodeSet.add(new Integer(10));
        nodeSet.add(new Integer(20));
        nodeSet.add(new Integer(30));
        nodeSet.add(new Integer(10));
        nodeSet.add(new Integer(20));
 
        System.out.println(nodeSet.size());

            System.out.println(new Timestamp(System.currentTimeMillis()).toLocalDateTime());


            String format = Instant.ofEpochMilli(System.currentTimeMillis())
                    .atZone(ZoneId.systemDefault())
                    .format(DateTimeFormatter.ISO_INSTANT);

            System.out.println(format);
}
 
}
	
	
