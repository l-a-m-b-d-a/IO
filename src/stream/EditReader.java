package stream;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EditReader {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String[] indicatorWord = new String[args.length - 1];
        System.arraycopy(args, 1, indicatorWord, 0, args.length - 1);
        String temp;
        List<String> list = new ArrayList<>();
        // i don't use ignore case
        while ((temp = bufferedReader.readLine()) != null) {
            for (String s : indicatorWord) {
                if (temp.contains(s)) {
                    list.add(temp);
                    break;
                }
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

