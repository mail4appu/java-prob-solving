package Collections_FrmWrk.MapExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapApp {
    public static void main(String[] args) {
        Map<String, String> myMap= new HashMap<>();

        myMap.put("Arun", "Tcs");
        myMap.put("Charan", "Cts");
        myMap.put("Nitin", "Wipro");
        myMap.put("Rajan", "Ibm");
        System.out.println(myMap); // {key1=value1, key2=value2}
        Set<Map.Entry<String, String>> entries = myMap.entrySet();
        for(Map.Entry<String,String> entry: entries){
            System.out.println(entry.getKey()+" : "+ entry.getValue());
        }


    }
}
