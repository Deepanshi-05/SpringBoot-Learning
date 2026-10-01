package repository;

import model.Task;

public interface TaskRepository {
    Task getTask(int id);

    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(int id);

}
