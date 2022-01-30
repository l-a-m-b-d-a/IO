package objectfile;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        File f = new File("/Users/adyubaicloud.com/Documents/Java/IOJava/IO/src/objectfile/stud.txt");
        Student student = new Student(20, "Alex", "Dyuba",
                new Group(50501, 3215546, 7.6));
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(f));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            ous.writeObject(student);

            Student st = (Student) ois.readObject();
            System.out.println(st);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
