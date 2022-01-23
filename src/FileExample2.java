import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class FileExample2 {
    public static FilenameFilter dirFilter(String regex) {
        return new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(final String[] args) {
        File path = new File("src");
        String[] names;
        if (args.length != 0) {
            names = path.list(dirFilter(args[0]));
        } else {
            names = path.list();
        }
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
