package stream.linenumberreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;

public class Liner {
    public static void main(String[] args) {
        int amountLine = 0;
        try (LineNumberReader lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader(args[0])))) {
            while(lineNumberReader.readLine() != null);
            amountLine = lineNumberReader.getLineNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(amountLine);
    }
}
