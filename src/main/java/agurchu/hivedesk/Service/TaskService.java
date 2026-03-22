package agurchu.hivedesk.Service;

import agurchu.hivedesk.model.task.Task;
import agurchu.hivedesk.model.task.TaskStatus;
import agurchu.hivedesk.model.user.User;
import agurchu.hivedesk.repository.InMemoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TaskService {
    private final InMemoryRepository repo;


    public TaskService(InMemoryRepository repo) {
        this.repo = repo;
    }

    public Task createTask(String title, String des, LocalDate dueDate, int estimatedMinutes){
        Task task = new Task(title,des, dueDate, estimatedMinutes);
        String id = UUID.randomUUID().toString().substring(0,8);
        task.setId(id);
        repo.add(task)
       return  task;
    }
    public void assignTask(Task task, User assignee){
        if(task == null ||assignee == null)return;

        task.assignedTo(assignee);
    }
    public void updateTaskStatus(Task task, TaskStatus taskStatus){
        task.setStatus(taskStatus);
    }

    public List<Task> getTaskAssignedTo(User user){
        return  user.getAssignedTasks();
    }
    public Task findTaskById(String id){
        List<Task> tasks = repo.getTasks();
        for (Task task : tasks){
            if (task.getId().equals(id)) return task;
        }
        return null;

    }

}
