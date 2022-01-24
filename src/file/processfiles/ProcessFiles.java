package file.processfiles;

import file.directory.Directory;

import java.io.File;
import java.io.IOException;
import java.time.*;
// определяет файлы в каталоге созданые позже выбраной даты
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;
    private LocalDateTime data;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public ProcessFiles(Strategy strategy, String ext, Integer[] data) {
        this.strategy = strategy;
        this.ext = ext;
        this.data = LocalDateTime.of(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(
                                new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            if(checkTime(file.lastModified()) > 0) {
                strategy.process(file.getCanonicalFile());
            }
        }
    }

    public long checkTime(long timeFile) {
        return timeFile - data.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static void main(String[] args) {
        Integer[] i =  {2022, 1, 20, 10, 15, 30};
        new ProcessFiles(new Strategy() {
            public void process(File file) {
                System.out.println(file);
                System.out.println(Instant
                        .ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate());
            }
        }, "java", i).start(args);
    }
}
