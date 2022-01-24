package file.directory;

import java.util.Collection;

public class DirFilePrint {
    public static String dirFileFormat(Collection<?> c) {
        if (c.size() == 0)
            return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Object object : c) {
            if (c.size() != 1) {
                stringBuilder.append("\n  ");
            }
            stringBuilder.append(object);
        }
        if (c.size() != 1) {
            stringBuilder.append("\n");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
