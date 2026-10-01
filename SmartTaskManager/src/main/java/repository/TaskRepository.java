package repository;

import model.Task;

import java.util.List;

public interface TaskRepository {
    Task getTask(int id);

    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(int id);

    void markTaskCompleted(int id);

    List<Task> getAllTasks();
}
