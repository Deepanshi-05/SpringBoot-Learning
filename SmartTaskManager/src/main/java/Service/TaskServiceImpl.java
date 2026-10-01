package Service;

import org.springframework.stereotype.Service;
import repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
     TaskServiceImpl(TaskRepository taskRepository){
         this.taskRepository = taskRepository;
     }



}
