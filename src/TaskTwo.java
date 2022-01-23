// write a program which summary size all files in directory

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

class FileSize {
    public static void main(String[] args) {
        // code duplicate (CLASS FILEEXAMPLE1) but i know about DRY
        long sizeDirectory = 0;
        String path = "/Users/adyubaicloud.com/Documents/Java/collections-practice/src/arraylist";
        File file = new File(path);
        String[] names;
        if (args.length != 0) {
            names = file.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        } else {
            names = file.list();
        }

        for (String name : names) {
            sizeDirectory += new File(path + "/" + name).length();
        }
        System.out.println("Result size: " + sizeDirectory);
    }
}
