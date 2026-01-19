package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MapSerializationTest {


    public static void main(String[] args) throws IOException {
        Map<String, Student> studentMap= new HashMap<>();
        Student student= new Student();
        student.setId("1");
        student.setName("Apparao");
        //student.setDept("Engg");
        FileOutputStream fileOutputStream
                = new FileOutputStream("student.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        studentMap.put("Bangalore", student);
        objectOutputStream.writeObject(studentMap);
        objectOutputStream.flush();
        objectOutputStream.close();



    }
}
