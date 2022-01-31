package externalizable;

import objectfile.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ByteArray {
    public static void main(String[] args) {
        Human h1 = new Human(12, "Alex", "Dyuba");
        Human h2 = new Human(13, "Pir", "Asd");
        Human h3 = new Human(14, "Oleg", "Qwerty");
        List<Human> newHumanList = new ArrayList<>();
            File f = new File("/Users/adyubaicloud.com/Documents/Java/IOJava/IO/src/externalizable/exmpl.txt");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.flush();
            objectOutputStream.close();
            objectOutputStream.writeObject(h1);
            objectOutputStream.writeObject(h2);
            objectOutputStream.writeObject(h3);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            newHumanList.add((Human) objectInputStream.readObject());
            newHumanList.add((Human) objectInputStream.readObject());
            newHumanList.add((Human) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Human human : newHumanList) {
            System.out.println(human);
        }

    }
}
