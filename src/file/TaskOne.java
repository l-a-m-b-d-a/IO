package file;// Создайте класс с именем file.SortedDirList,конструктор которого принимает информацию
// о пути к каталогу и на основе этой информации составляет отсортированный список файлов в указанном каталоге.
// Создайте два перегруженных метода list (), один должен возвращать весь список файлов, другой —подмножество списка,
// соответствующее аргументу (регулярное выражение).

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class SortedDirList {
    private File path;
    private String[] names;

    public SortedDirList(String path) {
        this.path = new File(path);
    }

    private void sort(String[] names) {
        Arrays.sort(names);
    }

    public String[] list() {
        names = path.list();
        sort(names);
        return names;
    }

    public String[] list(String regex) {
        return path.list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }
}

class Test {
    public static void main(String[] args) {
        SortedDirList sortedDirList =
                new SortedDirList("/Users/adyubaicloud.com/Documents/Java/collections-practice/src/arraylist");

        String[] directories = sortedDirList.list();
        for (String directory : directories) {
            System.out.println(directory);
        }

        directories = sortedDirList.list(".*F.*\\.java");
        for (String directory : directories) {
            System.out.println(directory);
        }
    }
}

