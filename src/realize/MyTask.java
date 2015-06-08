package realize;

import interfases.Task;
import interfases.TaskExecutionFailedException;

/**
 * Created by Макс on 08.06.2015.
 */
public abstract class MyTask implements Task {

    private int tryCount = 0;

    public int getTryCount() {
        return this.tryCount;
    }

    public void incTryCount() {
        this.tryCount++;
    }
}
