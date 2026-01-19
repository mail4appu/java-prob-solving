package Collections_FrmWrk;

import java.util.*;

public class LinkedHashMap   {

    public static void main(String[] args) {
        java.util.LinkedHashMap<Integer,String> linkedHashMap=new java.util.LinkedHashMap(6, 2f, true){
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > 6;
            }

        };
        linkedHashMap.put(5, "Vizag");
        linkedHashMap.put(8, "Hyderbad");
        linkedHashMap.put(3, "Kolkatta");
        linkedHashMap.put(4, "Pune");
        linkedHashMap.put(1, "Chennai");
        linkedHashMap.put(2, "Banagalore");

        System.out.println(linkedHashMap);

        linkedHashMap.get(5);
        System.out.println(linkedHashMap);

        linkedHashMap.get(3);
        System.out.println(linkedHashMap);

        linkedHashMap.put(7, "Mumbai");

        System.out.println(linkedHashMap);



    }

}
