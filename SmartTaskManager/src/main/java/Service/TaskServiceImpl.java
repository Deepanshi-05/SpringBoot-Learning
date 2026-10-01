package Service;

import model.Task;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
     TaskServiceImpl(TaskRepository taskRepository){
         this.taskRepository = taskRepository;
     }

    public void createTask(int id, String title) {
        Task task = new Task(id, title, false);
        taskRepository.addTask(task);
    }

    @Override
    public Task createTask(String title) {
        return null;
    }

    public Task listTasks() {
        return (Task) taskRepository.getAllTasks();
    }

    public Task completeTask(int id) {
        taskRepository.markTaskCompleted(id);
        return null;
    }


}
