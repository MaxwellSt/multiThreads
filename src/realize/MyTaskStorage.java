package realize;

import interfases.Task;
import interfases.TasksStorage;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Макс on 08.06.2015.
 */
public class MyTaskStorage implements TasksStorage {

    private List<Task> tasks = new LinkedList<Task>();

    public synchronized void add(Task task) throws NullPointerException {
        if (task == null)
            throw new NullPointerException("task == null");
        tasks.add(task);
    }

    public synchronized Task get() {
        if (tasks.isEmpty()){
            return null;
        }else {
            return tasks.remove(0);
        }
    }

    public synchronized int count() {
        return tasks.size();
    }
}
