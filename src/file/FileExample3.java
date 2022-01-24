package file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
// with anon class
public class FileExample3 {
    public static void main(String[] args) {
        File path = new File("src/file");
        String[] names;
        if (args.length != 0) {
            names = path.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        } else {
            names = path.list();
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
