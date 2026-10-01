package Service;

import model.Task;

public interface TaskService {
    Task createTask(String title);

    Task listTasks();
    Task completeTask(int id);

}
