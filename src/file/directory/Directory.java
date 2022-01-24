package file.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
// find all files and dir
public final class Directory {
    public static File[] local(File dir, String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return
                    "files: " + DirFilePrint.dirFileFormat(files) + "\n\n" +
                    "dirs: " + DirFilePrint.dirFileFormat(dirs);
        }
    }
    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");

    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo res = new TreeInfo();
        for(File item : startDir.listFiles()) {
            if(item.isDirectory()) {
                res.dirs.add(item);
                res.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    res.files.add(item);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(walk(".", ".*\\.java"));
    }
}
