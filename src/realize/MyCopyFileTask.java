package realize;

import interfases.CopyFileTask;
import interfases.TaskExecutionFailedException;
import utils.CopyFile;

import java.security.cert.Extension;

/**
 * Created by Макс on 08.06.2015.
 */
public class MyCopyFileTask extends MyTask implements CopyFileTask {

    private CopyFile copyUtils;
    private String from;
    private String to;

    public MyCopyFileTask(CopyFile copyUtils, String to, String from) {
        super();
        this.copyUtils = copyUtils;
        this.to = to;
        this.from = from;
    }

    public void setFileCopyUtils(CopyFile copyUtils) {

    }

    public void execute() throws TaskExecutionFailedException {
        try {
            copyUtils.copy(from, to);
        }catch (Exception e){
            throw new TaskExecutionFailedException(e.getMessage());
        }

    }
}
