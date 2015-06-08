package realize;

import interfases.Task;
import interfases.TaskExecutionFailedException;
import interfases.TaskExecutor;
import interfases.TasksStorage;

/**
 * Created by Макс on 08.06.2015.
 */
public class MyTaskExecutor implements Runnable, TaskExecutor {

    private TasksStorage storage;
    private boolean stopFlag = false;

    public void run() {
        while (!stopFlag) {
            Task task = this.storage.get();
            if (task == null) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    task.execute();
                } catch (TaskExecutionFailedException e) {
                    if (task.getTryCount() < 5) {
                        this.storage.add(task);
                    } else {
                        System.out.println("can't do task");
                    }
                }
            }
        }
    }

    public void setStorage(TasksStorage storage) throws NullPointerException {
        this.storage = storage;
    }

    public TasksStorage getStorage() {
        return this.storage;
    }

    public void start() throws NullPointerException, IllegalStateException {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() throws IllegalStateException {
        this.stopFlag = true;
    }
}
