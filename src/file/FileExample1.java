package file;// получения содержимого каталогов с помощью регулярных выражений
import java.io.*;
import java.util.regex.Pattern;

public class FileExample1 {

    public static void main(String[] args) {
        java.io.File path = new java.io.File("src");

        String[] list;
        if (args.length != 0) {
            list = path.list(new DirectoryFilter(args[0]));
        } else {
            list = path.list();
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
// strategy
class DirectoryFilter implements FilenameFilter {
    private final Pattern pattern;

    public DirectoryFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(java.io.File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
