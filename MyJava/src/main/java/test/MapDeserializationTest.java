package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class MapDeserializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream("student.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Map<String, Student> studentMap = (HashMap<String, Student>) objectInputStream.readObject();
        studentMap.entrySet().stream().forEach(entry->{
              String key=entry.getKey();
              Student student= entry.getValue();;
            System.out.println(student.getName());
        });
        objectInputStream.close();
    }
}
