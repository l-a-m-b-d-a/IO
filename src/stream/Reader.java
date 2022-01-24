package stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// read file to arL and after reverse it
public class Reader {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));;
        List<String> listFile = new ArrayList<>();
        String temp;
        while((temp = bufferedReader.readLine()) != null) {
            listFile.add(temp);
        }
        for (String s : listFile) {
            System.out.println(s);
        }
        Collections.reverse(listFile);
        for (String s : listFile) {
            System.out.println(s);
        }

    }
}
