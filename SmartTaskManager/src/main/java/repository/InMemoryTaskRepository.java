package repository;

import model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTaskRepository implements TaskRepository{
    private final List<Task> tasks = new ArrayList<>();


    @Override
    public Task getTask(int id) {
        for(Task task: tasks){
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void updateTask(Task task) {
        for(Task existingTask: tasks){
            if(existingTask.getId() == task.getId()){
                existingTask.setTitle(task.getTitle());
                existingTask.setCompleted(task.isCompleted());
            }
        }
    }

    @Override
    public void deleteTask(int id) {
        tasks.remove(getTask(id));
    }
}
