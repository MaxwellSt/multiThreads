package realize;

import interfases.CopyFileTask;
import interfases.FindFilesTask;
import interfases.TaskExecutionFailedException;
import utils.CopyFile;
import utils.FindFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by Макс on 08.06.2015.
 */
public class MyFindFilesTask extends MyTask implements FindFilesTask {

    private FindFile findUtils;
    private String path;
    private String mask;
    private String searchWord;
    private PrintStream out;

    public MyFindFilesTask(FindFile findUtils, String path, String searchWord) {
        super();
        this.findUtils = findUtils;
        this.path = path;
        this.searchWord = searchWord;
    }

    public MyFindFilesTask(FindFile findUtils, String path, String searchWord, String mask) {
        super();
        this.findUtils = findUtils;
        this.path = path;
        this.mask = mask;
        this.searchWord = searchWord;
    }

    public void execute() throws TaskExecutionFailedException {
        try {
            if (mask == null || mask == "") {
                for (String resFile : findUtils.find(path, searchWord)) {
                    System.out.println(resFile);
                }
            } else {
                for (String resFile : findUtils.find(path, searchWord, mask)) {
                    System.out.println(resFile);
                }
            }
        } catch (Exception e) {
            throw new TaskExecutionFailedException(e.getMessage());
        }
    }

    public void setDirectory(String directory) throws NullPointerException, FileNotFoundException {
        if (directory == null) {
            throw new NullPointerException("directory == null");
        }
        File file = new File(directory);
        if (!file.exists()) {
            throw new FileNotFoundException("path not found");
        }
        this.path = directory;
    }

    public void setFileNameSearchString(String searchString) throws IllegalArgumentException {
        try {
            this.searchWord = searchString;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void setPrintStream(PrintStream out) {
        this.out = out;
    }
}
