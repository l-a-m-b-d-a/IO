package stream.printwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        PrintWriter printWriter =
                new PrintWriter("/Users/adyubaicloud.com/Documents/Java/IOJava/IO/src/stream/printwriter/resultFile.txt");
        List<String> list = new ArrayList<>();
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            list.add(temp);
        }

        for (int i = 0; i < list.size(); i++) {
            printWriter.println(i + 1 + " " + list.get(i));
        }
        printWriter.close();
    }
}
